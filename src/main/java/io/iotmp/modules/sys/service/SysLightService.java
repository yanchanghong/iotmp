package io.iotmp.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.modules.sys.entity.SysLightEntity;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/12 22:23
 * @Version 1.0
 **/
public interface SysLightService extends IService<SysLightEntity> {
     Double totalEnergy(Long orgId, Long regionId, String status);
}
