package com.yinhai.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.yinhai.base.controller.BaseController;
import com.yinhai.base.domain.ImgDomain;
import com.yinhai.base.result.Result;
import com.yinhai.base.result.ResultCode;
import com.yinhai.base.util.ValidateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 保存示例
 * @author qiurong
 * @version 1.0.0
 * @Description
 * @ClassName SaveController.java
 * @createTime 2021年04月15日 10:45:00
 */
@RestController
@RequestMapping("/save")
public class SaveController extends BaseController {

    @RequestMapping("/saveDemo")
    public Object save(HttpServletRequest request, HttpServletResponse response){
        Map params = getParams();
        String yab003 = (String) params.get("yab003");
        if(ValidateUtil.isEmpty(params.get("files"))){
            return Result.failure(ResultCode.PARAM_NOT_COMPLETE,"未上传图片");
        }
        List<ImgDomain> files = (List<ImgDomain>) params.get("files");
        for (ImgDomain imgDomain : files) {
            //调用Hutool工具类将图片写入本地
            byte[] imgByte = Base64.decode(imgDomain.getBase64());
            String type = imgDomain.getName().substring(imgDomain.getName().lastIndexOf("."));
            UUID uuid = UUID.randomUUID();
            String saveId = uuid.toString().replaceAll("-", "");
            IoUtil.write(FileUtil.getOutputStream("D://imgs/" + saveId + type), true, imgByte);
        }
        //返回成功
        return Result.successMsg("提交成功");
    }
}
