

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.CategoryEntity;
import io.iotmp.modules.manage.entity.PointGroupRelEntity;
import io.iotmp.modules.manage.entity.PointGroupEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 点位分组
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysPointGroupDao extends BaseMapper<PointGroupEntity> {

    List<CategoryEntity> queryListByPointId(Integer id);

    void deleteByRelId(Integer id);

    void insertPointGroupRel(PointGroupRelEntity devGroupRelEntity);

}
