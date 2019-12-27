

package io.iotmp.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Yanchanghong
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
