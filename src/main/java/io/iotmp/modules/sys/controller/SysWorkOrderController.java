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
import io.iotmp.modules.sys.service.SysWorkOrderService;
import io.iotmp.modules.sys.vo.request.WorkOrderReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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
 * 工单流程
 *
 * @author changhong.yan
 */
@Slf4j
@Controller
@Api(description = "工单流程管理")
@RestController
@RequestMapping(value = "/api/v1/sys/workorder", produces = MediaType.APPLICATION_JSON_VALUE)
public class SysWorkOrderController {
    @Autowired
    private SysWorkOrderService sysWorkOrderService;

    /**
     * 列表
     */
    @ApiModelProperty(value = "根据状态和关键字查询列表")
    @ResponseBody
    @GetMapping("/list/{userName}")
    //@RequiresPermissions("sys:log:list")
    public R list(@ApiParam(value = "用户名称", required = true, defaultValue = "admin")
                  @PathVariable(name = "userName") String userName, WorkOrderReq workOrderReq) {
        PageUtils page = sysWorkOrderService.queryPage(userName, workOrderReq);
        return R.ok().put("data", page);
    }

    @ApiOperation("批量删除工单")
    @PostMapping("/delete")
    public R delete(@RequestBody Long[] orderIds) {
        if (orderIds.length == 0) {
            return R.error("请勾选需要删除的工单");
        }
        sysWorkOrderService.deleteBatch(orderIds);
        return R.ok();
    }


    @ResponseBody
    @GetMapping("/total")
    public R getTotal() {
        Map<String, Object> params = new HashMap<>();
        params.put("weekAmount", 900);
        params.put("dealingAmount", 100);
        params.put("unDealAmount", 100);
        return R.ok().put("data", params);
    }
}
