

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.PointsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 点位管理
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysPointsDao extends BaseMapper<PointsEntity> {


}
