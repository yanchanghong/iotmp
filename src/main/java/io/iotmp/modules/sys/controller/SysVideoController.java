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
 * 系统日志
 *
 * @author changhong.yan
 */
@Slf4j
@Controller
@Api(tags = "视频监控管理")
@RestController
@RequestMapping(value = "/api/v1/sys/video", produces = MediaType.APPLICATION_JSON_VALUE)
public class SysVideoController {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping("/syslog/list")
    //@RequiresPermissions("sys:log:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysLogService.queryPage(params);

        return R.ok().put("data", page);
    }

    @ResponseBody
    @GetMapping("/total")
    public R getTotal() {
        Map<String, Object> params = new HashMap<>();
        params.put("runAmount", 900);
        params.put("closeAmount", 100);
        params.put("alertAmount", 100);
        return R.ok().put("data", params);
    }
}
