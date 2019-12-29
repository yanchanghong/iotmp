package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.vo.request.AddDeviceReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.UpdateDeviceReq;
import io.iotmp.modules.manage.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/11 15:47
 * @Version 1.0
 **/
@RestController
@Api(tags = "设备管理")
@RequestMapping(value = "/api/v1/config/project/device")
public class SysProDeviceController {

    @Autowired
    private DeviceService deviceService;

    @ApiOperation(value = "获取设备列表", notes = "获取设备列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(SearchPageReq searchPageReq) {
        return R.ok().put("data", deviceService.queryList(searchPageReq));
    }

    @ApiOperation(value = "添加设备", notes = "添加设备")
    @ResponseBody
    @PostMapping("/add")
    public R add(@RequestBody AddDeviceReq addDeviceReq) {
        deviceService.add(addDeviceReq);
        return R.ok();
    }

    @ApiOperation(value = "修改设备", notes = "修改设备")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdateDeviceReq updateDeviceReq) {
        deviceService.update(updateDeviceReq);
        return R.ok();
    }

    @ApiOperation(value = "获取设备", notes = "通过ID获取设备")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Integer id) {
        return R.ok().put("data", deviceService.getById(id));
    }

    @ApiOperation(value = "删除设备", notes = "通过ID删除设备")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Integer id) {
        deviceService.deleteById(id);
        return R.ok();
    }
}
