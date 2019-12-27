package io.iotmp.modules.sys.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.sys.service.SysRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/12 20:49
 * @Version 1.0
 **/
@RestController
@Api(tags = "区域管理")
@RequestMapping(value = "/api/v1/region", produces = MediaType.APPLICATION_JSON_VALUE)
public class SysRegionController {

    @Autowired
    private SysRegionService sysRegionsService;

    @ApiOperation(value = "获取区域列表", notes = "根据机构ID获取该机构下得区域列表")
    @GetMapping("/list")
    public R listRegion(@RequestParam @ApiParam(required = true, name = "orgId", value = "机构ID") Long orgId) {
        return R.ok().put("data", sysRegionsService.listRegion(orgId));
    }

    @ApiOperation(value = "获取区域显示地图还是背景图片", notes = "根据区域ID显示地图或背景图片")
    @GetMapping("/{orgId}/{regionId}")
    public R showImageById(@PathVariable("orgId") @ApiParam(name = "orgId", value = "机构ID") Long orgId, @PathVariable("regionId") @ApiParam(name = "regionId", value = "区域ID") Long regionId) {

        return R.ok().put("data", 1);
    }

}
