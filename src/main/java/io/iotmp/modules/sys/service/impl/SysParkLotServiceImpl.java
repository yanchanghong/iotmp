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
import io.iotmp.modules.sys.dao.SysParkLotDao;
import io.iotmp.modules.sys.entity.SyParkLotRecordEntity;
import io.iotmp.modules.sys.entity.SysLogEntity;
import io.iotmp.modules.sys.service.SysLogService;
import io.iotmp.modules.sys.service.SysParkLotRecordService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;


@Service("sysParkLotService")
public class SysParkLotServiceImpl extends ServiceImpl<SysParkLotDao, SyParkLotRecordEntity> implements SysParkLotRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        if (params.size() != 0) {
            String platNumber = "";
            String region = "";
            if (params.get("platNumber") != null && params.get("region") == null) {
                platNumber = ((String) params.get("platNumber"));
                IPage<SyParkLotRecordEntity> page = this.page(
                        new Query<SyParkLotRecordEntity>().getPage(params),
                        new QueryWrapper<SyParkLotRecordEntity>().like(true, "plat_number", platNumber).orderByAsc("create_date")
                );
                return new PageUtils(page);
            } else if (params.get("region") != null && params.get("platNumber") == null) {
                region = ((String) params.get("region"));
                IPage<SyParkLotRecordEntity> page = this.page(
                        new Query<SyParkLotRecordEntity>().getPage(params),
                        new QueryWrapper<SyParkLotRecordEntity>().eq(true, "region", region).orderByAsc("create_date")
                );
                return new PageUtils(page);
            } else {
                platNumber = ((String) params.get("platNumber"));
                region = ((String) params.get("region"));
                IPage<SyParkLotRecordEntity> page = this.page(
                        new Query<SyParkLotRecordEntity>().getPage(params),
                        new QueryWrapper<SyParkLotRecordEntity>().like(true, "plat_number", platNumber).eq(true, "region", region).orderByAsc("create_date")
                );
                return new PageUtils(page);
            }
        } else {
            IPage<SyParkLotRecordEntity> page = this.page(
                    new Query<SyParkLotRecordEntity>().getPage(params),
                    new QueryWrapper<SyParkLotRecordEntity>().orderByAsc("create_date")
            );
            return new PageUtils(page);
        }

    }
}
