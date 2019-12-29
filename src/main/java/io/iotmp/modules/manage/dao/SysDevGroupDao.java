

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.DevGroupEntity;
import io.iotmp.modules.manage.entity.DevTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 设备分组
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysDevGroupDao extends BaseMapper<DevGroupEntity> {

    List<DevGroupEntity> queryList();

}
