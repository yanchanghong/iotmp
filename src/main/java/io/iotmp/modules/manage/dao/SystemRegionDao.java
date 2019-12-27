

package io.iotmp.modules.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.manage.entity.RegionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典管理
 *
 * @author Yanchanghong
 */
@Mapper
public interface SystemRegionDao extends BaseMapper<RegionEntity> {

    List<RegionEntity> queryList();

}
