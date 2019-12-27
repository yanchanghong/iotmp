

package io.iotmp.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.sys.entity.SysCaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {

}
