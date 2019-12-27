package io.iotmp.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.modules.sys.dao.SysRegionDao;
import io.iotmp.modules.sys.entity.SysLogEntity;
import io.iotmp.modules.sys.entity.SysRegionEntity;
import io.iotmp.modules.sys.service.SysRegionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/12 21:11
 * @Version 1.0
 **/
@Service("sysRegionService")
public class SysRegionServiceImpl extends ServiceImpl<SysRegionDao, SysRegionEntity> implements SysRegionService {
    @Override
    public List<SysRegionEntity> listRegion(Long orgId) {
        return this.list(new QueryWrapper<SysRegionEntity>().eq(true, "org_id", orgId));
    }
}
