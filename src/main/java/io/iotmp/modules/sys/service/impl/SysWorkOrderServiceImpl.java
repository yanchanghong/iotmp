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
import io.iotmp.modules.sys.vo.request.*;
import io.iotmp.modules.sys.vo.response.TimeListResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service("sysWorkOrderService")
public class SysWorkOrderServiceImpl extends ServiceImpl<SysWorkOrderDao, SysWorkOrderEntity> implements SysWorkOrderService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

    @Override
    public void createWorkOrder(AddWorkOrderReq addWorkOrderReq) {
        SysWorkOrderEntity sysWorkOrderEntity = new SysWorkOrderEntity();
        sysWorkOrderEntity.setTitle(addWorkOrderReq.getTitle());
        sysWorkOrderEntity.setDescription(addWorkOrderReq.getDescription());
        sysWorkOrderEntity.setAuditorUser(addWorkOrderReq.getAuditorUser());
        sysWorkOrderEntity.setOperationUser(addWorkOrderReq.getOperationUser());
        sysWorkOrderEntity.setCreateTime(new Date());
        sysWorkOrderEntity.setStatus(1);
        sysWorkOrderEntity.setDistributionTime(new Date());
        this.save(sysWorkOrderEntity);
    }

    @Override
    public void finishWorkOrder(FinishWorkOrderReq finishWorkOrderReq) {
        SysWorkOrderEntity sysWorkOrderEntity = new SysWorkOrderEntity();
        sysWorkOrderEntity.setCompletionTime(new Date());
        sysWorkOrderEntity.setRemark(finishWorkOrderReq.getFinishRemark());
        sysWorkOrderEntity.setId(finishWorkOrderReq.getId());
        sysWorkOrderEntity.setStatus(2);
        this.saveOrUpdate(sysWorkOrderEntity);
    }

    @Override
    public void refuseWorkOrder(RefuseWorkOrderReq refuseWorkOrderReq) {
        SysWorkOrderEntity sysWorkOrderEntity = new SysWorkOrderEntity();
        sysWorkOrderEntity.setRefuseTime(new Date());
        sysWorkOrderEntity.setRefuseReson(refuseWorkOrderReq.getRefuseReson());
        sysWorkOrderEntity.setStatus(0);
        sysWorkOrderEntity.setId(refuseWorkOrderReq.getId());
        this.saveOrUpdate(sysWorkOrderEntity);
        sysWorkOrderEntity.setId(null);
        sysWorkOrderEntity.setParentId(refuseWorkOrderReq.getId());
        sysWorkOrderEntity.setStatus(0);
        sysWorkOrderEntity.setCreateTime(new Date());
        this.save(sysWorkOrderEntity);
    }

    @Override
    public void redistributionWorkOrder(RedistributionWorkOrderReq redistributionWorkOrder) {
        SysWorkOrderEntity sysWorkOrderEntity = new SysWorkOrderEntity();
        sysWorkOrderEntity.setStatus(1);
        sysWorkOrderEntity.setId(redistributionWorkOrder.getId());
        this.saveOrUpdate(sysWorkOrderEntity);
        sysWorkOrderEntity.setId(null);
        sysWorkOrderEntity.setRedistributionTime(new Date());
        sysWorkOrderEntity.setTitle(redistributionWorkOrder.getTitle());
        sysWorkOrderEntity.setDescription(redistributionWorkOrder.getDescription());
        sysWorkOrderEntity.setOperationUser(redistributionWorkOrder.getOperationUser());
        sysWorkOrderEntity.setStatus(1);
        sysWorkOrderEntity.setParentId(redistributionWorkOrder.getId());
        sysWorkOrderEntity.setCreateTime(new Date());
        this.save(sysWorkOrderEntity);
    }

    @Override
    public List<TimeListResp> getTimeListByOrderId(Long id) {
        List<Map<String, Object>> result = baseMapper.getTimeListByOrderId(id);
        List<TimeListResp> timeList = new ArrayList();
        if (result.size() > 0) {
            TimeListResp timeListResp = new TimeListResp();
            timeListResp.setDescription("派发时间");
            timeListResp.setDate(sdf.format(result.get(0).get("createTime")));
            timeList.add(timeListResp);
            for (Map<String, Object> map : result) {
                if (map.get("refuseTime") != null) {
                    TimeListResp timeListResp1 = new TimeListResp();
                    timeListResp1.setDescription("拒绝工单");
                    timeListResp1.setDate(sdf.format(map.get("refuseTime")));
                    timeList.add(timeListResp1);
                }
                if (map.get("redistributionTime") != null) {
                    TimeListResp timeListResp1 = new TimeListResp();
                    timeListResp1.setDescription("重新派发");
                    timeListResp1.setDate(sdf.format(map.get("redistributionTime")));
                    timeList.add(timeListResp1);
                }
            }
        }
        return timeList;
    }

    @Override
    public List<SysWorkOrderEntity> detail(Long id) {
        List<SysWorkOrderEntity> list = new ArrayList<>();
        SysWorkOrderEntity sysWorkOrderEntity = this.getById(id);
        if (sysWorkOrderEntity != null) {
            list.add(sysWorkOrderEntity);
            List<SysWorkOrderEntity> result = baseMapper.detail(id);
            list.addAll(result);
            if (sysWorkOrderEntity.getStatus() != null && sysWorkOrderEntity.getStatus().intValue() == 2) {
                list.add(sysWorkOrderEntity);
            }
        }
        return list;
    }
}
