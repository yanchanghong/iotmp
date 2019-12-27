

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.CategoryEntity;
import io.iotmp.modules.sys.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典管理
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysCategoryDao extends BaseMapper<CategoryEntity> {

    List<CategoryEntity> queryList();

}
