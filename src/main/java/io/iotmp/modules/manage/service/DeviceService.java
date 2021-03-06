package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.DeviceEntity;
import io.iotmp.modules.manage.entity.SubDevicePointRelEntity;
import io.iotmp.modules.manage.vo.request.*;
import io.swagger.models.auth.In;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface DeviceService extends IService<DeviceEntity> {

    PageUtils queryList(SearchDevicePageReq searchDevicePageReq);

    void add(AddDeviceReq addDeviceReq);

    void update(UpdateDeviceReq updateDeviceReq);

    DeviceEntity findByID(Integer id);

    void deleteById(Integer id);

    void addSubDev(AddSubDeviceReq addSubDeviceReq);

    void bindPoint(AddSubDevicePointRelReq addSubDevicePointRelReq);

    PageUtils querySubDeviceList(SearchSubDevicePageReq searchSubDevicePageReq);

}
