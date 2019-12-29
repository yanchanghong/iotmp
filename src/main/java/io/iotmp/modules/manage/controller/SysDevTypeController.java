package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.DevTypeService;
import io.iotmp.modules.manage.vo.request.AddDevTypeReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.UpdateDevTypeReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName 设备类别
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/11 15:47
 * @Version 1.0
 **/
@RestController
@Api(tags = "设备类别管理")
@RequestMapping(value = "/api/v1/config/project/devType")
public class SysDevTypeController {

    @Autowired
    private DevTypeService DevTypeService;

    @ApiOperation(value = "获取设备类别列表", notes = "获取设备类别列表")
    @ResponseBody
    @GetMapping("/list")
    public R listDevType(SearchPageReq searchDevTypeReq) {
        return R.ok().put("data", DevTypeService.queryList(searchDevTypeReq));
    }

    @ApiOperation(value = "添加设备类别", notes = "添加设备类别")
    @ResponseBody
    @PostMapping("/add")
    public R add(@RequestBody AddDevTypeReq addDevTypeReq){
        DevTypeService.add(addDevTypeReq);
        return R.ok();
    }
    @ApiOperation(value = "修改设备类别", notes = "修改设备类别")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdateDevTypeReq updateDevTypeReq) {
        DevTypeService.update(updateDevTypeReq);
        return R.ok();
    }

    @ApiOperation(value = "获取设备类别", notes = "通过ID获取设备类别")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        return R.ok().put("data", DevTypeService.findByID(id));
    }

    @ApiOperation(value = "删除设备类别", notes = "通过ID删除设备类别")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        DevTypeService.deleteById(id);
        return R.ok();
    }

}


