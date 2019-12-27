package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.CategoryEntity;
import io.iotmp.modules.manage.entity.DevPicEntity;
import io.iotmp.modules.manage.vo.request.*;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface DevPicService extends IService<DevPicEntity> {

    void add(AddDevPicReq addDevPicReq);

    String categoryCode(Long id);

    void update(UpdateDevPicReq updateDevPic);

    void deleteById(Integer id);

    PageUtils queryPage(SearchDevPicReq searchDevPicReq);

    DevPicEntity getById(Integer id);
}
