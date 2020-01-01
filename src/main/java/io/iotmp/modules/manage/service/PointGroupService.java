package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.DevGroupEntity;
import io.iotmp.modules.manage.entity.PointGroupEntity;
import io.iotmp.modules.manage.vo.request.*;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface PointGroupService extends IService<PointGroupEntity> {

    PageUtils queryList(SearchpointGroupReq searchpointGroupReq);

    void add(AddPointGroupReq addPointGroupReq);

    void update(UpdatePointGroupReq pdatePointGroupReq);

    PointGroupEntity findByID(Long id);

    void deleteById(Long id);

    void bindCategory(AddPointGroupRelReq addPointGroupRelReq);

    void unbind(Integer id);
}
