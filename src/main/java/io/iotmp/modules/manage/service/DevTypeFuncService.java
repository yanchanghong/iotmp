package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.DevGroupEntity;
import io.iotmp.modules.manage.entity.DevTypeFuncEntity;
import io.iotmp.modules.manage.vo.request.*;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface DevTypeFuncService extends IService<DevTypeFuncEntity> {

    PageUtils queryList(SearchDevTypeFuncReq searchDevTypeFuncReq);

    void add(AddDevTypeFuncReq addDevTypeFuncReq);

    void update(UpdateDevTypeFuncReq updateDevTypeFuncReq);

    DevTypeFuncEntity findByID(Long id);

    void deleteById(Long id);
}
