

package io.iotmp.modules.oss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.oss.entity.SysOssEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {
	
}
