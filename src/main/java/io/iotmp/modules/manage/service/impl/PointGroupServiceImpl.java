package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysDevGroupDao;
import io.iotmp.modules.manage.dao.SysPointGroupDao;
import io.iotmp.modules.manage.entity.CategoryEntity;
import io.iotmp.modules.manage.entity.DevGroupEntity;
import io.iotmp.modules.manage.entity.PointGroupEntity;
import io.iotmp.modules.manage.entity.PointGroupRelEntity;
import io.iotmp.modules.manage.service.CategoryService;
import io.iotmp.modules.manage.service.DevGroupService;
import io.iotmp.modules.manage.service.PointGroupService;
import io.iotmp.modules.manage.vo.request.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("pointGroupService")
@Slf4j
public class PointGroupServiceImpl extends ServiceImpl<SysPointGroupDao, PointGroupEntity> implements PointGroupService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private DevGroupService devGroupService;

    @Autowired
    private SysPointGroupDao sysPointGroupDao;

    @Override
    public PageUtils queryList(SearchpointGroupReq searchpointGroupReq) {
        SearchDevGroupReq searchDevGroupReq = new SearchDevGroupReq();
        searchDevGroupReq.setDevTypeId(searchpointGroupReq.getDevTypeId());
        searchDevGroupReq.setPage(searchpointGroupReq.getPage());
        searchDevGroupReq.setPageSize(searchpointGroupReq.getPageSize());
        PageUtils page = devGroupService.queryList(searchDevGroupReq);
        for (DevGroupEntity groupEntity : (List<DevGroupEntity>) page.getList()) {
            List<PointGroupEntity> pointGroupEntityList = baseMapper.selectList(new QueryWrapper<PointGroupEntity>().eq("dev_type_id", groupEntity.getId()).orderByDesc("create_time"));
            groupEntity.setChildrenPointGroup(pointGroupEntityList);
            for (PointGroupEntity entity : pointGroupEntityList) {
                List<CategoryEntity> categories = sysPointGroupDao.queryListByPointId(entity.getId());
                entity.setChildren(categories);
            }
        }
        return page;
    }

    @Override
    public void add(AddPointGroupReq addPointGroupReq) {
        PointGroupEntity pointGroupEntity = new PointGroupEntity();
        pointGroupEntity.setName(addPointGroupReq.getName());
        pointGroupEntity.setStyleType(addPointGroupReq.getStyleType());
        pointGroupEntity.setCreateTime(new Date());
        pointGroupEntity.setDevTypeId(addPointGroupReq.getDevTypeId());
        baseMapper.insert(pointGroupEntity);
    }


    @Override
    public void update(UpdatePointGroupReq pdatePointGroupReq) {
        PointGroupEntity pointGroupEntity = baseMapper.selectById(pdatePointGroupReq.getId());
        if (pointGroupEntity != null) {
            pointGroupEntity.setName(pdatePointGroupReq.getName());
            pointGroupEntity.setStyleType(pdatePointGroupReq.getStyleType());
            pointGroupEntity.setUpdateTime(new Date());
            baseMapper.updateById(pointGroupEntity);
        }
    }

    @Override
    public PointGroupEntity findByID(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        //删除该分组点位下绑定得字典点位类别
        List<CategoryEntity> categories = sysPointGroupDao.queryListByPointId(Integer.valueOf(id + ""));
        for (CategoryEntity entity : categories) {
            sysPointGroupDao.deleteByRelId(entity.getId());
        }
        baseMapper.deleteById(id);
    }

    @Override
    public void bindCategory(AddPointGroupRelReq addPointGroupRelReq) {
        PointGroupRelEntity pointGroupRelEntity = new PointGroupRelEntity();
        pointGroupRelEntity.setCategoryId(addPointGroupRelReq.getCategoryTypeId());
        pointGroupRelEntity.setPointGroupId(addPointGroupRelReq.getPointGroupId());
        pointGroupRelEntity.setCreateTime(new Date());
        sysPointGroupDao.insertPointGroupRel(pointGroupRelEntity);
    }

    @Override
    public void unbind(Integer id) {
        sysPointGroupDao.deleteByRelId(id);
    }
}
