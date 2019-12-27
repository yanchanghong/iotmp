package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.vo.request.AddRegionReq;
import io.iotmp.modules.manage.vo.request.SearchRegionReq;
import io.iotmp.modules.manage.vo.request.UpdateRegionReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.iotmp.modules.manage.service.RegionService;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/11 15:47
 * @Version 1.0
 **/
@RestController
@Api(tags = "区域管理")
@RequestMapping(value = "/api/v1/config/project/region")
public class SystemRegionController {

    @Autowired
    private RegionService RegionService;

    @ApiOperation(value = "获取设备列表", notes = "根据设备名称查询设备列表")
    @ResponseBody
    @GetMapping("/list")
    public R listRegion(SearchRegionReq searchRegionReq) {
        return R.ok().put("data", RegionService.queryList(searchRegionReq));
    }

    @ApiOperation(value = "添加", notes = "添加系统，添加设备，添加点位")
    @ResponseBody
    @PostMapping("/add")
    public R add(@RequestBody AddRegionReq addRegionReq){
        RegionService.add(addRegionReq);
        return R.ok();
    }
    @ApiOperation(value = "修改区域", notes = "修改系统，修改设备，修改点位")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdateRegionReq updateRegionReq) {
        RegionService.update(updateRegionReq);
        return R.ok();
    }

    @ApiOperation(value = "获取区域", notes = "通过ID获取区域")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        return R.ok().put("data", RegionService.findByID(id));
    }

    @ApiOperation(value = "删除区域", notes = "通过ID删除区域")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        RegionService.deleteById(id);
        return R.ok();
    }

}


