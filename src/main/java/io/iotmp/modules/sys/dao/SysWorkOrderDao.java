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
import io.iotmp.modules.sys.entity.SysWorkOrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 工单管理
 *
 * @author changhong.yan
 */
@Mapper
public interface SysWorkOrderDao extends BaseMapper<SysWorkOrderEntity> {

}