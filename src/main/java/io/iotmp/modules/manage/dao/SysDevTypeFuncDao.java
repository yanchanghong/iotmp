

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.DevGroupEntity;
import io.iotmp.modules.manage.entity.DevTypeFuncEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 设备分组
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysDevTypeFuncDao extends BaseMapper<DevTypeFuncEntity> {

    List<DevTypeFuncEntity> queryList();

}
