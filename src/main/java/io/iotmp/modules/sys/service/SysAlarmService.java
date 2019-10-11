/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.sys.entity.SysAlarmEntity;
import io.iotmp.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 设备告警管理
 *
 * @author changhong.yan
 */
public interface SysAlarmService extends IService<SysAlarmEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
