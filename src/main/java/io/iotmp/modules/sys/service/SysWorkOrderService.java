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
import io.iotmp.modules.sys.entity.SysUserEntity;
import io.iotmp.modules.sys.entity.SysWorkOrderEntity;
import io.iotmp.modules.sys.vo.request.*;
import io.iotmp.modules.sys.vo.response.TimeListResp;

import java.util.List;
import java.util.Map;


/**
 * 工单
 *
 * @author changhong.yan
 */
public interface SysWorkOrderService extends IService<SysWorkOrderEntity> {

    PageUtils queryPage(String userName, WorkOrderReq workOrderReq);

    void deleteBatch(Long[] orderIds);

    void createWorkOrder(AddWorkOrderReq addWorkOrderReq);

    void finishWorkOrder(FinishWorkOrderReq finishWorkOrderReq);

    void refuseWorkOrder(RefuseWorkOrderReq refuseWorkOrderReq);

    void redistributionWorkOrder(RedistributionWorkOrderReq refuseWorkOrderReq);

    List<TimeListResp> getTimeListByOrderId(Long id);

    List<SysWorkOrderEntity> detail(Long id);
}
