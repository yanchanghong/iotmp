package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.DevGroupEntity;
import io.iotmp.modules.manage.entity.DevTypeEntity;
import io.iotmp.modules.manage.vo.request.*;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface DevGroupService extends IService<DevGroupEntity> {

    PageUtils queryList(SearchDevGroupReq searchDevGroupReq);

    void add(AddDevGroupReq adGroupReq);

    void update(UpdateDevGroupReq updateDevGroupReq);

    DevGroupEntity findByID(Long id);

    void deleteById(Long id);

    PageUtils queryListByTypeId(SearchDevGroupReq searchDevGroupReq);
}
