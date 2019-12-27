package io.iotmp.modules.sys.dao;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/12 22:36
 * @Version 1.0
 **/

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.sys.entity.SysLightEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysLightDao extends BaseMapper<SysLightEntity> {
    Double totalEnergy(@Param("orgId") Long orgId, @Param("regionId") Long regionId, @Param("status") String status);
}
