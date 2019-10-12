/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.sys.dao.SysLogDao;
import io.iotmp.modules.sys.dao.SysWorkOrderDao;
import io.iotmp.modules.sys.entity.SysAlarmEntity;
import io.iotmp.modules.sys.entity.SysLogEntity;
import io.iotmp.modules.sys.entity.SysWorkOrderEntity;
import io.iotmp.modules.sys.service.SysLogService;
import io.iotmp.modules.sys.service.SysWorkOrderService;
import io.iotmp.modules.sys.vo.request.WorkOrderReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service("sysWorkOrderService")
public class SysWorkOrderServiceImpl extends ServiceImpl<SysWorkOrderDao, SysWorkOrderEntity> implements SysWorkOrderService {

    @Override
    public PageUtils queryPage(String userName, WorkOrderReq workOrderReq) {
        Map<String, Object> params = new HashMap<>();
        params.put("page", workOrderReq.getPage() + "");
        params.put("pageSize", workOrderReq.getPageSize() + "");
        IPage<SysWorkOrderEntity> page = this.page(
                new Query<SysWorkOrderEntity>().getPage(params),
                new QueryWrapper<SysWorkOrderEntity>().eq("auditor_user", userName).eq(workOrderReq.getStatus().intValue() != 6, "status", workOrderReq.getStatus())
                        .and(StringUtils.isNotEmpty(workOrderReq.getKeyword()), i -> i.like(StringUtils.isNotEmpty(workOrderReq.getKeyword()), "title", workOrderReq.getKeyword()).or().like(StringUtils.isNotEmpty(workOrderReq.getKeyword()), "title", workOrderReq.getKeyword()))
                        .eq("parent_id", 0).orderByDesc("create_time")
        );
        return new PageUtils(page);
    }

    @Override
    public void deleteBatch(Long[] logIds) {
        this.removeByIds(Arrays.asList(logIds));
    }
}
