/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.sys.entity.SyParkLotRecordEntity;
import io.iotmp.modules.sys.entity.SyParkLotSettingEntity;

import java.util.Map;


/**
 * 停车场设置信息表
 *
 * @author changhong.yan
 * @Date 2019/10/05
 */
public interface SysParkLotSettingService extends IService<SyParkLotSettingEntity> {

    SyParkLotSettingEntity querySetting();

}
