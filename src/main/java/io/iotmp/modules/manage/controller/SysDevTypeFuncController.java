package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.DevGroupService;
import io.iotmp.modules.manage.service.DevTypeFuncService;
import io.iotmp.modules.manage.vo.request.*;
import io.iotmp.modules.manage.vo.response.GroupPicResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description 方法配置
 * @Author changhong.yan
 * @Date 2019/12/11 15:47
 * @Version 1.0
 **/
@RestController
@Api(tags = "项目中方法配置")
@RequestMapping(value = "/api/v1/config/project/devTypeFunc")
public class SysDevTypeFuncController {

    @Autowired
    private DevTypeFuncService devTypeFuncService;

    @ApiOperation(value = "获取设备类别已经绑定方法列表", notes = "获取设备类别已经绑定方法列表")
    @ResponseBody
    @GetMapping("/list")
    public R listDevType(SearchDevTypeFuncReq searchDevTypeFuncReq) {
        return R.ok().put("data", devTypeFuncService.queryList(searchDevTypeFuncReq));
    }

    @ApiOperation(value = "绑定方法", notes = "给设备类型，子设备类型，以及字典点位绑定方法")
    @ResponseBody
    @PostMapping("/bind")
    public R add(@Valid @RequestBody AddDevTypeFuncReq addDevTypeFuncReq) {
        devTypeFuncService.add(addDevTypeFuncReq);
        return R.ok();
    }

    @ApiOperation(value = "修改绑定方法的名称或者参数", notes = "修改绑定方法")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdateDevTypeFuncReq updateDevTypeFuncReq) {
        devTypeFuncService.update(updateDevTypeFuncReq);
        return R.ok();
    }

    @ApiOperation(value = "获取设备分组", notes = "通过ID获取设备分组")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        return R.ok().put("data", devTypeFuncService.findByID(id));
    }

    @ApiOperation(value = "删除设备分组", notes = "通过ID删除设备分组")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        devTypeFuncService.deleteById(id);
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


