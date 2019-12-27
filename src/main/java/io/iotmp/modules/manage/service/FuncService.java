package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.DevPicEntity;
import io.iotmp.modules.manage.entity.FuncEntity;
import io.iotmp.modules.manage.vo.request.*;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface FuncService extends IService<FuncEntity> {

    void add(AddFuncReq addFuncReq);

    void update(UpdateFuncReq updateFuncReq);

    void deleteById(Integer id);

    PageUtils queryPage(SearchPageReq searchPageReq);

    FuncEntity getById(Integer id);
}
