package shizuka.infrastructure.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import shizuka.infrastructure.dal.model.Demo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author muzhi
 * @create 2021/7/23
 */
public class JsonUtil {
    private static Object object = new Object();
    private static ObjectMapper objectMapper;

    private static ObjectMapper getObjectMapperInstance(){
        if (objectMapper == null){
            synchronized (object){
                if (objectMapper == null){
                    objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);
                    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,true);
                    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
                }
            }
        }
        return objectMapper;
    }

    public static String toJsonString(Object o){
        try {
            return getObjectMapperInstance().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseObject(String json,Class<T> tClass){
        try {
            return getObjectMapperInstance().readValue(json,tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        Set<Demo> set = new HashSet<>();
        Demo demo1 = new Demo();
        demo1.setId(1L);
        demo1.setDesc("1");
        set.add(demo1);

        Demo demo2 = new Demo();
        demo2.setId(2L);
        demo2.setDesc("2");
        set.add(demo2);

        String jsonStr = toJsonString(set);

        Set<Demo> res = parseObject(jsonStr, Set.class);

        if (res.contains(demo1)){
            System.out.println("存在");
        }
        System.out.println("res");
    }
}
