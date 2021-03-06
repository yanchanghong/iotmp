/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 *
 * @author Yanchanghong
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {

}
