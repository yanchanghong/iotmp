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
import io.iotmp.modules.sys.vo.response.SysDevLogResp;
import io.iotmp.modules.sys.vo.response.SysLoginLogResp;
import io.iotmp.utils.Utills;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;


/**
 * 系统日志
 *
 * @author changhong.yan
 */
@Slf4j
@Controller
@Api(description = "日志接口")
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class SysLogController {
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

    @ApiOperation("日志导出")
    @GetMapping(value = "/syslog/export")
    @ResponseBody
    public R export(HttpServletRequest request, HttpServletResponse response,
                    @RequestParam Map<String, Object> params) throws IOException {
        PageUtils page = sysLogService.queryPage(params);
        List<SysLogEntity> data = (List<SysLogEntity>) page.getList();
        Integer type = Integer.parseInt((String) params.get("type"));
        if (type == 0) {
            List<SysLoginLogResp> sysLoginLogResps = new ArrayList<SysLoginLogResp>();
            for (SysLogEntity sysLogEntity : data) {
                SysLoginLogResp sysLoginLogResp = new SysLoginLogResp();
                sysLoginLogResp.setIp(sysLogEntity.getIp());
                sysLoginLogResp.setUsername(sysLogEntity.getUsername());
                sysLoginLogResp.setDept(sysLogEntity.getDept());
                sysLoginLogResp.setCreateDate(sysLogEntity.getCreateDate());
                sysLoginLogResps.add(sysLoginLogResp);
            }
            try {
                Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, "登录日志导出"), SysLoginLogResp.class, sysLoginLogResps);
                OutputStream out = new BufferedOutputStream(response.getOutputStream());
                String fileName = "登录日志信息_" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + ".xls";
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
                response.setHeader("Content-Disposition", "attachment;fileName=" + Utills.encodeDownloadFileName(request, fileName));
                workbook.write(out);
                out.flush();
                out.close();
            } catch (IOException | ExcelExportException e) {
                log.error("failed to export excel", e);
                return R.ok();
//            throw new NEException(NEError.WRITE_EXCEL_ERROR);
            } finally {
                IOUtils.closeQuietly(response.getOutputStream());
            }
        } else {
            List<SysDevLogResp> sysDevLogResps = new ArrayList<SysDevLogResp>();
            for (SysLogEntity sysLogEntity : data) {
                SysDevLogResp sysLoginLogResp = new SysDevLogResp();
                sysLoginLogResp.setIp(sysLogEntity.getIp());
                sysLoginLogResp.setUsername(sysLogEntity.getUsername());
                sysLoginLogResp.setDept(sysLogEntity.getDept());
                sysLoginLogResp.setCreateDate(sysLogEntity.getCreateDate());
                sysLoginLogResp.setOperation(sysLogEntity.getOperation());
                sysLoginLogResp.setDeviceName(sysLogEntity.getDeviceName());
                sysDevLogResps.add(sysLoginLogResp);
            }
            try {
                Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, "设备控制日志导出"), SysDevLogResp.class, sysDevLogResps);
                OutputStream out = new BufferedOutputStream(response.getOutputStream());
                String fileName = "设备控制日志信息_" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + ".xls";
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
                response.setHeader("Content-Disposition", "attachment;fileName=" + Utills.encodeDownloadFileName(request, fileName));
                workbook.write(out);
                out.flush();
                out.close();
            } catch (IOException | ExcelExportException e) {
                log.error("failed to export excel", e);
                return R.ok();
//            throw new NEException(NEError.WRITE_EXCEL_ERROR);
            } finally {
                IOUtils.closeQuietly(response.getOutputStream());
            }
        }
        return R.ok();
    }

    @ApiOperation("删除日志")
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] logIds) {
        if (logIds.length == 0) {
            return R.error("请勾选需要删除的日志");
        }
        sysLogService.deleteBatch(logIds);
        return R.ok();
    }

}
