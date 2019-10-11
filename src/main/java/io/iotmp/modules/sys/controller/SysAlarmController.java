/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.controller;

import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.R;
import io.iotmp.modules.sys.service.SysAlarmService;
import io.iotmp.modules.sys.service.SysLogService;
import io.swagger.annotations.Api;
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
@Api(description = "告警管理")
@RestController
@RequestMapping(value = "/api/v1/sys/alarm", produces = MediaType.APPLICATION_JSON_VALUE)
public class SysAlarmController {
    @Autowired
    private SysAlarmService SysAlarmService;

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = SysAlarmService.queryPage(params);
        return R.ok().put("data", page);
    }
}
