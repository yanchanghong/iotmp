

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.DeviceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 设备类别
 *
 * @author canoelu
 */
@Mapper
public interface SysDeviceDao extends BaseMapper<DeviceEntity> {

    List<DeviceEntity> queryList();

}
