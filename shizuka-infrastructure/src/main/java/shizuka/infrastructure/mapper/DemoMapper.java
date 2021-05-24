package shizuka.infrastructure.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-24 18:23
 */
public interface DemoMapper {
    String selectDrugName(@Param("zoneId")Integer zoneId,@Param("drugId")String drugId);
}
