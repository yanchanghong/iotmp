

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.FuncEntity;
import io.iotmp.modules.manage.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目管理
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysProjectDao extends BaseMapper<ProjectEntity> {


}
