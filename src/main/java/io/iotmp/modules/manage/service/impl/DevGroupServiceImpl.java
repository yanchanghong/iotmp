package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysDevGroupDao;
import io.iotmp.modules.manage.dao.SysDevTypeDao;
import io.iotmp.modules.manage.entity.CategoryEntity;
import io.iotmp.modules.manage.entity.DevGroupEntity;
import io.iotmp.modules.manage.entity.DevTypeEntity;
import io.iotmp.modules.manage.service.CategoryService;
import io.iotmp.modules.manage.service.DevGroupService;
import io.iotmp.modules.manage.service.DevTypeService;
import io.iotmp.modules.manage.vo.request.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("devGroupService")
@Slf4j
public class DevGroupServiceImpl extends ServiceImpl<SysDevGroupDao, DevGroupEntity> implements DevGroupService {

    @Autowired
    private CategoryService categoryService;

    @Override
    public PageUtils queryList(SearchDevGroupReq searchDevGroupReq) {
        if (searchDevGroupReq.getPage() == null) {
            searchDevGroupReq.setPage(1L);
        }
        if (searchDevGroupReq.getPageSize() == null) {
            searchDevGroupReq.setPageSize(10L);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("page", searchDevGroupReq.getPage() + "");
        params.put("pageSize", searchDevGroupReq.getPageSize() + "");
        IPage<DevGroupEntity> page = this.page(
                new Query<DevGroupEntity>().getPage(params),
                new QueryWrapper<DevGroupEntity>().eq("sys_dev_type_id", searchDevGroupReq.getDevTypeId()).orderByDesc("create_time")
        );
        for (DevGroupEntity devGroupEntity : page.getRecords()) {
            CategoryEntity categoryEntity = categoryService.findByID(Long.valueOf(devGroupEntity.getSysCategoryId() + ""));
            if (categoryEntity != null) {
                devGroupEntity.setCategoryName(categoryEntity.getName());
            }
        }
        return new PageUtils(page);
    }

    @Override
    public void add(AddDevGroupReq addDevGroupReq) {
        DevGroupEntity devGroupEntity = new DevGroupEntity();
        devGroupEntity.setSysCategoryId(addDevGroupReq.getSysCategoryId());
        devGroupEntity.setType(addDevGroupReq.getType());
        devGroupEntity.setCreateTime(new Date());
        devGroupEntity.setSysDevTypeId(addDevGroupReq.getDevTypeId());
        devGroupEntity.setUrl(addDevGroupReq.getUrl());
        baseMapper.insert(devGroupEntity);
    }


    @Override
    public void update(UpdateDevGroupReq updateDevGroupReq) {
        DevGroupEntity devGroupEntity = baseMapper.selectById(updateDevGroupReq.getId());
        if (devGroupEntity != null) {
            devGroupEntity.setSysCategoryId(updateDevGroupReq.getSysCategoryId());
            devGroupEntity.setType(updateDevGroupReq.getType());
            devGroupEntity.setUpdateTime(new Date());
            devGroupEntity.setUrl(updateDevGroupReq.getUrl());
            baseMapper.updateById(devGroupEntity);
        }
    }

    @Override
    public DevGroupEntity findByID(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void deleteById(Long id) {
        baseMapper.deleteById(id);
    }

}
