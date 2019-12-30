package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.DevGroupService;
import io.iotmp.modules.manage.service.DevTypeService;
import io.iotmp.modules.manage.vo.request.*;
import io.iotmp.modules.manage.vo.response.GroupPicResp;
import io.iotmp.modules.manage.vo.response.PlaceCodeResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 设备分组
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/11 15:47
 * @Version 1.0
 **/
@RestController
@Api(tags = "设备分组(子设备)管理")
@RequestMapping(value = "/api/v1/config/project/devGroup")
public class SysDevGroupController {

    @Autowired
    private DevGroupService devGroupService;

    @ApiOperation(value = "获取设备类别列表", notes = "获取设备类别列表")
    @ResponseBody
    @GetMapping("/list")
    public R listDevType(SearchDevGroupReq searchDevGroupReq) {
        return R.ok().put("data", devGroupService.queryList(searchDevGroupReq));
    }

    @ApiOperation(value = "添加设备分组", notes = "添加设备分组")
    @ResponseBody
    @PostMapping("/add")
    public R add(@RequestBody AddDevGroupReq addDevGroupReq) {
        devGroupService.add(addDevGroupReq);
        return R.ok();
    }

    @ApiOperation(value = "修改设备分组", notes = "修改设备分组")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdateDevGroupReq updateDevGroupReq) {
        devGroupService.update(updateDevGroupReq);
        return R.ok();
    }

    @ApiOperation(value = "获取设备分组", notes = "通过ID获取设备分组")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        return R.ok().put("data", devGroupService.findByID(id));
    }

    @ApiOperation(value = "删除设备分组", notes = "通过ID删除设备分组")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        devGroupService.deleteById(id);
        return R.ok();
    }

    @ApiOperation(value = "获取图标列表", notes = "返回列表")
    @ResponseBody
    @GetMapping("/group/pic")
    public R listGroupPics() {
        List<GroupPicResp> list = new ArrayList<GroupPicResp>();
        GroupPicResp place1 = new GroupPicResp();
        place1.setName("图标1");
        place1.setUrl("hello");
        list.add(place1);
        GroupPicResp place2 = new GroupPicResp();
        place2.setName("图标2");
        place2.setUrl("test");
        list.add(place2);
        return R.ok().put("data", list);
    }
}


