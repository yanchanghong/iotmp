/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.exception.excel.ExcelExportException;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.R;
import io.iotmp.modules.sys.entity.SysLogEntity;
import io.iotmp.modules.sys.service.SysLogService;
import io.iotmp.modules.sys.service.SysParkLotRecordService;
import io.iotmp.modules.sys.vo.response.SysDevLogResp;
import io.iotmp.modules.sys.vo.response.SysLoginLogResp;
import io.iotmp.utils.Utills;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 停车场管理系统
 *
 * @author changhong.yan
 */
@Slf4j
@Controller
@Api(tags = "停车场管理系统")
@RestController
@RequestMapping(value = "/api/v1/parklot", produces = MediaType.APPLICATION_JSON_VALUE)
public class SysParkLotController {
    @Autowired
    private SysParkLotRecordService SysParkLotRecordService;

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping("/list")
    //@RequiresPermissions("sys:log:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = SysParkLotRecordService.queryPage(params);

        return R.ok().put("data", page);
    }

}
