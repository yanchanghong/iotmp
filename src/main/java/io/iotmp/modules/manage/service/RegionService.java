package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.RegionEntity;
import io.iotmp.modules.manage.vo.request.AddRegionReq;
import io.iotmp.modules.manage.vo.request.SearchRegionReq;
import io.iotmp.modules.manage.vo.request.UpdateRegionReq;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface RegionService extends IService<RegionEntity> {

    PageUtils queryList(SearchRegionReq searchRegionReq);

    void add(AddRegionReq addRegionReq);

    void update(UpdateRegionReq updateRegionReq);

    RegionEntity findByID(Long id);

    void deleteById(Long id);
}
