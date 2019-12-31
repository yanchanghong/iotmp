package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.CategoryEntity;
import io.iotmp.modules.manage.vo.request.AddCategoryReq;
import io.iotmp.modules.manage.vo.request.SearchCategoryReq;
import io.iotmp.modules.manage.vo.request.UpdateCategoryReq;
import io.iotmp.modules.sys.entity.SysLogEntity;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryList(SearchCategoryReq searchCategoryReq);

    List<CategoryEntity> queryListByType(Integer categoryTypeId);

    void add(AddCategoryReq addCategoryReq);

    void update(UpdateCategoryReq updateCategoryReq);

    CategoryEntity findByID(Long id);

    void deleteById(Long id);

    /**
     * @Description 通过ID查询该设备下得子字典
     * @param id
     * @return
     */
    List<CategoryEntity> queryListById(Long id);
}
