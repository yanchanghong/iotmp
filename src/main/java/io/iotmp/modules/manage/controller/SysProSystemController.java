package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.ProSystemService;
import io.iotmp.modules.manage.vo.request.AddProSystemReq;
import io.iotmp.modules.manage.vo.request.AddSystemDeviceReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.UpdateProSystemReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
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
@Api(tags = "系统管理")
@RequestMapping(value = "/api/v1/config/project/system")
public class SysProSystemController {

    @Autowired
    private ProSystemService ProSystemService;

    @ApiOperation(value = "获取系统列表", notes = "获取系统列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(SearchPageReq searchPageReq) {
        return R.ok().put("data", ProSystemService.queryList(searchPageReq));
    }

    @ApiOperation(value = "添加系统", notes = "添加系统")
    @ResponseBody
    @PostMapping("/add")
    public R add(@RequestBody AddProSystemReq addProSystemReq) {
        ProSystemService.add(addProSystemReq);
        return R.ok();
    }

    @ApiOperation(value = "修改系统", notes = "修改系统")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdateProSystemReq updateProSystemReq) {
        ProSystemService.update(updateProSystemReq);
        return R.ok();
    }

    @ApiOperation(value = "获取系统", notes = "通过ID获取系统")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Integer id) {
        return R.ok().put("data", ProSystemService.getById(id));
    }

    @ApiOperation(value = "删除系统", notes = "通过ID删除系统")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Integer id) {
        ProSystemService.deleteById(id);
        return R.ok();
    }

    @ApiOperation(value = "系统中添加设备", notes = "在地图或者背景图中添加设备")
    @ResponseBody
    @PostMapping("/device/add")
    public R addDevice(@RequestBody AddSystemDeviceReq addSystemDeviceReq) {
        ProSystemService.addDevice(addSystemDeviceReq);
        return R.ok();
    }

    @ApiOperation(value = "获取系统下区域中得设备列表", notes = "获取地图或者背景图片设备列表")
    @ResponseBody
    @GetMapping("/device/list")
    public R deviceList(@ApiParam(name = "systemId", required = true, value = "系统ID") @RequestParam("systemId") Integer systemId, @ApiParam(name = "regionId", required = true, value = "区域ID") @RequestParam("regionId") Integer regionId) {
        return R.ok().put("data", "");
    }
}
