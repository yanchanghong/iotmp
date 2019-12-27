package io.iotmp.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.modules.manage.entity.FuncEntity;
import io.iotmp.modules.manage.entity.ProjectEntity;
import io.iotmp.modules.manage.vo.request.*;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/18 16:48
 * @Version 1.0
 **/
public interface ProjectService extends IService<ProjectEntity> {

    void add(AddProjectReq addProjectReq);

    void update( UpdateProjectReq updateProjectReq);

    void deleteById(Integer id);

    PageUtils queryPage(SearchPageReq searchPageReq);

    ProjectEntity getById(Integer id);
}
