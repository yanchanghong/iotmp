package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.DevTypeEntity;
import io.iotmp.modules.manage.vo.request.AddDevTypeReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.UpdateDevTypeReq;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface DevTypeService extends IService<DevTypeEntity> {

    PageUtils queryList(SearchPageReq searchPageReq);

    void add(AddDevTypeReq addDevTypeReq);

    void update(UpdateDevTypeReq updateDevTypeReq);

    DevTypeEntity findByID(Long id);

    void deleteById(Long id);
}
