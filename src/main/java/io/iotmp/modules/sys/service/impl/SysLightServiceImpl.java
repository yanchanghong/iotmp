package io.iotmp.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.modules.sys.dao.SysLightDao;
import io.iotmp.modules.sys.entity.SysLightEntity;
import io.iotmp.modules.sys.service.SysLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/13 21:23
 * @Version 1.0
 **/
@Service("sysLightService")
public class SysLightServiceImpl extends ServiceImpl<SysLightDao, SysLightEntity> implements SysLightService {
    @Autowired
    private SysLightDao sysLightDao;

    @Override
    public Double totalEnergy(Long orgId, Long regionId, String status) {
        return sysLightDao.totalEnergy(orgId, regionId, status);
    }
}
