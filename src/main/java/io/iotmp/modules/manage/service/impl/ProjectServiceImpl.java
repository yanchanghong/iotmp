package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.exception.RRException;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysFuncDao;
import io.iotmp.modules.manage.dao.SysProjectDao;
import io.iotmp.modules.manage.entity.FuncEntity;
import io.iotmp.modules.manage.entity.ProjectEntity;
import io.iotmp.modules.manage.service.FuncService;
import io.iotmp.modules.manage.service.ProjectService;
import io.iotmp.modules.manage.vo.request.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/18 16:50
 * @Version 1.0
 **/
@Service("projectService")
@Slf4j
public class ProjectServiceImpl extends ServiceImpl<SysProjectDao, ProjectEntity> implements ProjectService {

    @Override
    public void add(AddProjectReq addProjectReq) {
        checkName(addProjectReq.getName());
        checkCode(addProjectReq.getCode());
        ProjectEntity entity = new ProjectEntity();
        entity.setName(addProjectReq.getName());
        entity.setCode(addProjectReq.getCode());
        entity.setUrl(addProjectReq.getUrl());
        entity.setCreateTime(new Date());
        baseMapper.insert(entity);
    }

    private void checkName(String name) {
        QueryWrapper<ProjectEntity> queryWrapper = new QueryWrapper<ProjectEntity>();
        queryWrapper.eq("name", name);
        ProjectEntity projectEntity = baseMapper.selectOne(queryWrapper);
        if (projectEntity != null) {
            throw new RRException("项目名称重复");
        }
    }

    private void checkCode(String code) {
        QueryWrapper<ProjectEntity> queryWrapper = new QueryWrapper<ProjectEntity>();
        queryWrapper.eq("code", code);
        ProjectEntity projectEntity = baseMapper.selectOne(queryWrapper);
        if (projectEntity != null) {
            throw new RRException("项目标识重复");
        }
    }

    @Override
    public void update(UpdateProjectReq updateProjectReq) {
        ProjectEntity project = baseMapper.selectById(updateProjectReq.getId());
        if (project == null) {
            throw new RRException("项目不存在");
        }
        if (!project.getName().equals(updateProjectReq.getName())) {
            checkName(updateProjectReq.getName());
        }
        if (!project.getCode().equals(updateProjectReq.getCode())) {
            checkCode(updateProjectReq.getCode());
        }
        ProjectEntity entity = new ProjectEntity();
        entity.setName(updateProjectReq.getName());
        entity.setCode(updateProjectReq.getCode());
        entity.setUrl(updateProjectReq.getUrl());
        entity.setUpdateTime(new Date());
        entity.setId(updateProjectReq.getId());
        baseMapper.updateById(entity);
    }

    @Override
    public void deleteById(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public PageUtils queryPage(SearchPageReq searchPageReq) {
        if (searchPageReq.getPage() == null) {
            searchPageReq.setPage(1L);
        }
        if (searchPageReq.getPageSize() == null) {
            searchPageReq.setPageSize(10L);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("page", searchPageReq.getPage() + "");
        params.put("pageSize", searchPageReq.getPageSize() + "");
        IPage<ProjectEntity> page = this.page(
                new Query<ProjectEntity>().getPage(params),
                new QueryWrapper<ProjectEntity>().orderByDesc("create_time")
        );
        return new PageUtils(page);
    }

    @Override
    public ProjectEntity getById(Integer id) {
        return baseMapper.selectById(id);
    }
}
