

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.DeviceEntity;
import io.iotmp.modules.manage.entity.SubDeviceEntity;
import io.iotmp.modules.manage.entity.SubDevicePointRelEntity;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 设备类别
 *
 * @author canoelu
 */
@Mapper
public interface SysDeviceDao extends BaseMapper<DeviceEntity> {

    List<DeviceEntity> queryList();

    void insertSubDevice(SubDeviceEntity subDevice);

    void insertSubDevicePointRel(SubDevicePointRelEntity subDevicePointRelEntity);

    List<SubDeviceEntity> queryListByDeviceId(@Param("deviceId") Integer deviceId, @Param("deviceTypeId") Integer deviceTypeId);

    SubDevicePointRelEntity getSubDevicePointRel(@Param("subDeviceId") Integer subDeviceId, @Param("pointId") Integer pointId, @Param("categoryId") Integer categoryId);

    List<SubDevicePointRelEntity>  getSubDevicePointRelList(@Param("subDeviceId") Integer subDeviceId);
}
