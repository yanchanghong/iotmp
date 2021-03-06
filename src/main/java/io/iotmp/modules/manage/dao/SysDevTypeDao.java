

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.DevTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 设备类别
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysDevTypeDao extends BaseMapper<DevTypeEntity> {

    List<DevTypeEntity> queryList();

}
