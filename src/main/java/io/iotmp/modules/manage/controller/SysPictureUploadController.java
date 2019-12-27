package io.iotmp.modules.manage.controller;

import io.iotmp.common.exception.RRException;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.DevPicService;
import io.iotmp.modules.manage.vo.request.AddDevPicReq;
import io.iotmp.modules.manage.vo.request.SearchDevPicReq;
import io.iotmp.modules.manage.vo.request.UpdateDevPicReq;
import io.iotmp.modules.manage.vo.response.DevPicStatusResp;
import io.iotmp.modules.manage.vo.response.PlaceCodeResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/11 15:47
 * @Version 1.0
 **/
@RestController
@Api(tags = "图片管理")
@RequestMapping(value = "/api/v1/config/picture")
public class SysPictureUploadController {

    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        //String deposeFilesDir = "E:\\test\\pic\\";
        String deposeFilesDir = "/var/pic/";
        //上传文件
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // 当文件有后缀名时
        String fileName = file.getOriginalFilename();
        if (fileName.indexOf(".") >= 0) {
            String[] fileNameSplitArray = fileName.split("\\.");
            fileName = fileNameSplitArray[0] + (int) (Math.random() * 100000) + "." + fileNameSplitArray[1];
        }
        if (fileName.indexOf(".") < 0) {
            fileName = fileName + (int) (Math.random() * 100000);
        }
        File dest = new File(deposeFilesDir + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 将获取到的附件file,transferTo写入到指定的位置(即:创建dest时，指定的路径)
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok().put("url", dest.getAbsolutePath());
    }

}
