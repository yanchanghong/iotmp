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

import java.util.List;
import java.util.Map;

/**
 * 工单管理
 *
 * @author changhong.yan
 */
@Mapper
public interface SysWorkOrderDao extends BaseMapper<SysWorkOrderEntity> {

    List<Map<String, Object>> getTimeListByOrderId(Long id);

    List<SysWorkOrderEntity> detail(Long id);

}
