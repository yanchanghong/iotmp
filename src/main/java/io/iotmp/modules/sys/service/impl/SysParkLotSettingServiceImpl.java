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
import io.iotmp.modules.sys.dao.SysParkLotDao;
import io.iotmp.modules.sys.dao.SysParkLotSettingDao;
import io.iotmp.modules.sys.entity.SyParkLotRecordEntity;
import io.iotmp.modules.sys.entity.SyParkLotSettingEntity;
import io.iotmp.modules.sys.service.SysParkLotRecordService;
import io.iotmp.modules.sys.service.SysParkLotSettingService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysParkLotSettingService")
public class SysParkLotSettingServiceImpl extends ServiceImpl<SysParkLotSettingDao, SyParkLotSettingEntity> implements SysParkLotSettingService {

    @Override
    public SyParkLotSettingEntity querySetting() {
        return null;
    }
}
