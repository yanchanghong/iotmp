

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.ProSystemEntity;
import io.iotmp.modules.manage.entity.SystemDevRelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 设备类别
 *
 * @author canoelu
 */
@Mapper
public interface SysProSystemDao extends BaseMapper<ProSystemEntity> {

    List<ProSystemEntity> queryList();

    void addSystemDevRel(SystemDevRelEntity systemDevRelEntity);

    List<SystemDevRelEntity> listDevices(@Param("systemId") Integer systemId, @Param("regionId") Integer regionId);

}
