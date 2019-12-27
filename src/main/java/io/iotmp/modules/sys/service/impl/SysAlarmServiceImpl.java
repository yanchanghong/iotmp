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
import io.iotmp.modules.sys.dao.SysAlarmDao;
import io.iotmp.modules.sys.dao.SysLogDao;
import io.iotmp.modules.sys.entity.SysAlarmEntity;
import io.iotmp.modules.sys.entity.SysLogEntity;
import io.iotmp.modules.sys.entity.SysWorkOrderEntity;
import io.iotmp.modules.sys.service.SysAlarmService;
import io.iotmp.modules.sys.service.SysLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service("sysAlarmService")
public class SysAlarmServiceImpl extends ServiceImpl<SysAlarmDao, SysAlarmEntity> implements SysAlarmService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper QueryWrapper = new QueryWrapper<SysAlarmEntity>();
        if (params.get("memuType") != null) {
            if (!params.get("memuType").equals("alarm")) {
                QueryWrapper.eq("sys_menu_type", params.get("memuType"));
            }
        }
        if (params.get("area") != null) {
            QueryWrapper.eq("alarm_area", params.get("area"));
        }
        if (params.get("deviceType") != null) {
            QueryWrapper.eq("device_type", params.get("deviceType"));
        }
        if (params.get("level") != null) {
            QueryWrapper.eq("alarm_level", params.get("level"));
        }
        if (params.get("date") != null) {
            Long time = Long.valueOf((String) params.get("date"));
            Date startTime = new Date(time);
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(time);
            c.add(Calendar.DAY_OF_MONTH, +1);
            Date endTime = c.getTime();
            QueryWrapper.between("create_time", startTime, endTime);
        }
        IPage<SysAlarmEntity> page = this.page(
                new Query<SysAlarmEntity>().getPage(params),
                QueryWrapper
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Long orgId, Long regionId, String deviceType, String keyWord, Integer page, Integer pageSize) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", page);
        params.put("pageSize", pageSize);
        IPage<SysAlarmEntity> iPage = this.page(
                new Query<SysAlarmEntity>().getPage(params),
                new QueryWrapper<SysAlarmEntity>().eq("device_type", deviceType).eq("org_id", orgId)
                        .and(StringUtils.isNotEmpty(keyWord), i -> i.like(StringUtils.isNotEmpty(keyWord), "device_name", keyWord).or().like(StringUtils.isNotEmpty(keyWord), "alarm_content", keyWord))
                        .orderByDesc("create_time"));
        return new PageUtils(iPage);
    }
}
