

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.CategoryEntity;
import io.iotmp.modules.manage.entity.DevPicEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 图列管理
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysDevPicDao extends BaseMapper<DevPicEntity> {


}
