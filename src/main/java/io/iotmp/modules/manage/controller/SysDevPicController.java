package io.iotmp.modules.manage.controller;

import io.iotmp.common.exception.RRException;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.DevPicService;
import io.iotmp.modules.manage.vo.request.*;
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
@Api(tags = "图列管理")
@RequestMapping(value = "/api/v1/config/devpic")
public class SysDevPicController {

    @Autowired
    private DevPicService devPicService;


    @ApiOperation(value = "状态选择", notes = "0表示关闭，1表示运行，2表示告警，3表示异常")
    @ResponseBody
    @GetMapping("/status")
    public R listStatus() {
        List<DevPicStatusResp> list = new ArrayList<DevPicStatusResp>();
        DevPicStatusResp pointTypeResp1 = new DevPicStatusResp();
        pointTypeResp1.setId(0);
        pointTypeResp1.setName("关闭");
        list.add(pointTypeResp1);
        DevPicStatusResp pointTypeResp2 = new DevPicStatusResp();
        pointTypeResp2.setId(1);
        pointTypeResp2.setName("运行");
        list.add(pointTypeResp2);
        DevPicStatusResp pointTypeResp3 = new DevPicStatusResp();
        pointTypeResp3.setId(2);
        pointTypeResp3.setName("告警");
        list.add(pointTypeResp3);
        DevPicStatusResp pointTypeResp4 = new DevPicStatusResp();
        pointTypeResp4.setId(3);
        pointTypeResp4.setName("异常");
        list.add(pointTypeResp4);
        return R.ok().put("data", list);
    }

    @ApiOperation(value = "获取替换代码", notes = "返回替换代码列表")
    @ResponseBody
    @GetMapping("/palceCode")
    public R listPlaceCode() {
        List<PlaceCodeResp> list = new ArrayList<PlaceCodeResp>();
        PlaceCodeResp place1 = new PlaceCodeResp();
        place1.setKey("{sys_name}");
        place1.setValue("设备所属系统名称");
        list.add(place1);
        PlaceCodeResp place2 = new PlaceCodeResp();
        place2.setKey("{{sys_id}}");
        place2.setValue("设备所属系统ID");
        list.add(place2);
        PlaceCodeResp place3 = new PlaceCodeResp();
        place3.setKey("{device_id}");
        place3.setValue("设备ID");
        list.add(place3);
        PlaceCodeResp place4 = new PlaceCodeResp();
        place4.setKey("{device_name}");
        place4.setValue("设备名称");
        list.add(place4);
        PlaceCodeResp place5 = new PlaceCodeResp();
        place5.setKey("{region_name}");
        place5.setValue("区域名称");
        list.add(place5);
        PlaceCodeResp place6 = new PlaceCodeResp();
        place6.setKey("{region_id}");
        place6.setValue("区域ID");
        list.add(place6);
        return R.ok().put("data", list);
    }

    @ApiOperation(value = "添加图列", notes = "添加图例")
    @ResponseBody
    @PostMapping("/add")
    public R add(@Valid @RequestBody AddDevPicReq addDevPicReq) {
        devPicService.add(addDevPicReq);
        return R.ok();
    }

    @ApiOperation(value = "修改图列", notes = "删除图例")
    @ResponseBody
    @PostMapping("/delete/{id}")
    public R delete(@PathVariable("id") @ApiParam(name = "id", value = "id") Integer id) {
        devPicService.deleteById(id);
        return R.ok();
    }

    @ApiOperation(value = "获取图列", notes = "获取图例")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Integer id) {
        return R.ok().put("data", devPicService.getById(id));
    }

    @ApiOperation(value = "查询列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(SearchDevPicReq searchDevPicReq) {
        PageUtils page = devPicService.queryPage(searchDevPicReq);
        return R.ok().put("data", page);
    }

    @ApiOperation(value = "删除图列", notes = "修改图例")
    @ResponseBody
    @PostMapping("/update")
    public R update(@Valid @RequestBody UpdateDevPicReq updateDevPicReq) {
        devPicService.update(updateDevPicReq);
        return R.ok();
    }

    @ApiOperation(value = "插入代码", notes = "根据字典点位插入样式代码")
    @ResponseBody
    @GetMapping("/category/code/{id}")
    public R categoryCode(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        return R.ok().put("data", devPicService.categoryCode(id));
    }


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
