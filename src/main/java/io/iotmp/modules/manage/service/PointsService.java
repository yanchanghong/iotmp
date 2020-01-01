package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.PointsEntity;
import io.iotmp.modules.manage.vo.request.AddPointsReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.SearchPointReq;
import io.iotmp.modules.manage.vo.request.UpdatePointsReq;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface PointsService extends IService<PointsEntity> {

    void add(AddPointsReq addPointsReq);

    void update(UpdatePointsReq updatePointsReq);

    void deleteById(Integer id);

    PageUtils queryPage(SearchPointReq searchPointReq);

    PointsEntity getById(Integer id);
}
