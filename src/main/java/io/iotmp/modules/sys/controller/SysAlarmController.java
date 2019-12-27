/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.R;
import io.iotmp.modules.sys.service.SysAlarmService;
import io.iotmp.modules.sys.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * 告警管理
 *
 * @author changhong.yan
 */
@Slf4j
@Controller
@Api(tags = "告警管理")
@RestController
@RequestMapping(value = "/api/v1/sys/alarm", produces = MediaType.APPLICATION_JSON_VALUE)
public class SysAlarmController extends AbstractController {
    @Autowired
    private SysAlarmService sysAlarmService;

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysAlarmService.queryPage(params);
        return R.ok().put("data", page);
    }

    @ApiOperation(value = "获取告警")
    @ResponseBody
    @GetMapping("/list/{orgId}/{regionId}")
    public R listAlarms(@PathVariable("orgId") @ApiParam(name = "orgId", value = "机构ID", required = true) Long orgId, @PathVariable("regionId") @ApiParam(name = "regionId", value = "区域ID", required = true) Long regionId, @RequestParam(name = "keyWord", required = false) @ApiParam(value = "关键字搜索") String keyWord, @RequestParam(name = "deviceType", required = true) @ApiParam(value = "设备类型") String deviceType, @RequestParam(name = "page", required = false) @ApiParam(value = "当前页码") Integer page, @RequestParam(name = "limit", required = false) @ApiParam(value = "每页显示条数") Integer pageSize) {
        PageUtils pageUtils = sysAlarmService.queryPage(orgId, regionId, deviceType, keyWord, page, pageSize);
        return R.ok().put("data", pageUtils);
    }
}
