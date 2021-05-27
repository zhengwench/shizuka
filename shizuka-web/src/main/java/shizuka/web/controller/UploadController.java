package shizuka.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import shizuka.query.UploadQueryService;
import shizuka.web.response.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 09:44
 */
@Slf4j
@RestController
public class UploadController extends BaseController {

    @Autowired
    private MultipartResolver multipartResolver;

    @Autowired
    private UploadQueryService uploadQueryService;

    @RequestMapping(value = "/upload/index")
    public ResponseResult index(){
        String res = uploadQueryService.test();
        return ResponseResult.ok(res);
    }

    /**
     * 上传图片，单个参数传多个文件
     * @param multipartFiles
     * @return
     */
    @RequestMapping(value = "/upload/file")
    public ResponseResult<Boolean> file(@RequestParam("file1") MultipartFile[] multipartFiles){
        System.out.println("file size" + multipartFiles.length);
        return ResponseResult.ok(true);
    }

    /**
     * 上传图片，多个参数多个图片
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping(value = "/upload/file2")
    public ResponseResult upload(HttpServletRequest req, HttpServletResponse resp){
        ResponseResult result = new ResponseResult();
        MultipartHttpServletRequest multipartRequest = null;
        try {
            if(multipartResolver.isMultipart(req)){
                multipartRequest = (MultipartHttpServletRequest) req;
                Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
                for(Map.Entry<String,MultipartFile> en:fileMap.entrySet()){
                    MultipartFile multipartFile = en.getValue();
                    //后缀
                    String fileName = multipartFile.getOriginalFilename();
                    String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                    return result;
                }
            }else{
                result.setMsg("无效的上传请求。");
            }
        } catch (Exception e) {
            result.setMsg("上传文件出现异常。");
        }finally{
            if(multipartRequest != null){
                multipartResolver.cleanupMultipart(multipartRequest);
            }
        }
        return result;
    }
}
