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
import io.iotmp.modules.sys.entity.SysLogEntity;
import io.iotmp.modules.sys.service.SysLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;


@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        if (params.get("startTime") != null && params.get("endTime") != null) {
            Long startTime = Long.valueOf((String) params.get("startTime"));
            Date start = new Date(startTime);
            Long endTime = Long.valueOf((String) params.get("endTime"));
            Date end = new Date(endTime);
            Integer type = Integer.parseInt((String) params.get("type"));
            IPage<SysLogEntity> page = this.page(
                    new Query<SysLogEntity>().getPage(params),
                    new QueryWrapper<SysLogEntity>().eq(true, "type", type).between("create_date", start, end)
            );
            return new PageUtils(page);
        } else {
            Integer type = Integer.parseInt((String) params.get("type"));
            IPage<SysLogEntity> page = this.page(
                    new Query<SysLogEntity>().getPage(params),
                    new QueryWrapper<SysLogEntity>().eq(true, "type", type)
            );
            return new PageUtils(page);
        }

    }

    @Override
    public void deleteBatch(Long[] logIds) {
        this.removeByIds(Arrays.asList(logIds));
    }
}
