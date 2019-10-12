/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.sys.entity.SysLogEntity;
import io.iotmp.modules.sys.entity.SysWorkOrderEntity;
import io.iotmp.modules.sys.vo.request.WorkOrderReq;

import java.util.Map;


/**
 * 工单
 *
 * @author changhong.yan
 */
public interface SysWorkOrderService extends IService<SysWorkOrderEntity> {

    PageUtils queryPage(String userName, WorkOrderReq workOrderReq);

    void deleteBatch(Long[] orderIds);
}
