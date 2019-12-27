package io.iotmp.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.modules.sys.entity.SysRegionEntity;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/12 21:09
 * @Version 1.0
 **/
public interface SysRegionService extends IService<SysRegionEntity> {

    List<SysRegionEntity> listRegion(Long orgId);
}
