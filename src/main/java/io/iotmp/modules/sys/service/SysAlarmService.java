

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

    PageUtils queryPage(Long orgId, Long regionId, String deviceType, String keyWord, Integer page, Integer pageSize);
}
