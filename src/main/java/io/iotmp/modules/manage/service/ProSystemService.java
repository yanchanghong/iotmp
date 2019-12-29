package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.ProSystemEntity;
import io.iotmp.modules.manage.vo.request.AddProSystemReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.UpdateProSystemReq;
import io.swagger.models.auth.In;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface ProSystemService extends IService<ProSystemEntity> {

    PageUtils queryList(SearchPageReq searchPageReq);

    void add(AddProSystemReq addProSystemReq);

    void update(UpdateProSystemReq updateProSystemReq);

    ProSystemEntity findByID(Integer id);

    void deleteById(Integer id);
}
