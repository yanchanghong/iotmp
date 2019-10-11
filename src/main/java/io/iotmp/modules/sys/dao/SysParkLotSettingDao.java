/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.iotmp.modules.sys.entity.SyParkLotRecordEntity;
import io.iotmp.modules.sys.entity.SyParkLotSettingEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 停车场管理系统
 *
 * @author changhong.yan
 * @Date 2019/10/05
 */
@Mapper
public interface SysParkLotSettingDao extends BaseMapper<SyParkLotSettingEntity> {

}
