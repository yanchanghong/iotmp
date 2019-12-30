package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysDevGroupDao;
import io.iotmp.modules.manage.dao.SysDevTypeFuncDao;
import io.iotmp.modules.manage.entity.DevGroupEntity;
import io.iotmp.modules.manage.entity.DevTypeFuncEntity;
import io.iotmp.modules.manage.service.DevGroupService;
import io.iotmp.modules.manage.service.DevTypeFuncService;
import io.iotmp.modules.manage.vo.request.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("devTypeFuncService")
@Slf4j
public class DevTypeFuncServiceImpl extends ServiceImpl<SysDevTypeFuncDao, DevTypeFuncEntity> implements DevTypeFuncService {
    @Override
    public PageUtils queryList(SearchDevTypeFuncReq searchDevTypeFuncReq) {

        if (searchDevTypeFuncReq.getPage() == null) {
            searchDevTypeFuncReq.setPage(1L);
        }
        if (searchDevTypeFuncReq.getPageSize() == null) {
            searchDevTypeFuncReq.setPageSize(10L);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("page", searchDevTypeFuncReq.getPage() + "");
        params.put("pageSize", searchDevTypeFuncReq.getPageSize() + "");
        IPage<DevTypeFuncEntity> page = this.page(
                new Query<DevTypeFuncEntity>().getPage(params),
                new QueryWrapper<DevTypeFuncEntity>().eq(searchDevTypeFuncReq.getDevTypeId() != null, "dev_type_id", searchDevTypeFuncReq.getDevTypeId()).eq("type", searchDevTypeFuncReq.getType()).eq(searchDevTypeFuncReq.getCategoryId() != null, "category_id", searchDevTypeFuncReq.getCategoryId()).orderByDesc("create_time")
        );

        return new PageUtils(page);
    }

    @Override
    public void add(AddDevTypeFuncReq addDevTypeFuncReq) {
        DevTypeFuncEntity devTypeFuncEntity = new DevTypeFuncEntity();
        devTypeFuncEntity.setName(addDevTypeFuncReq.getName());
        devTypeFuncEntity.setParams(addDevTypeFuncReq.getParams());
        devTypeFuncEntity.setType(addDevTypeFuncReq.getType());
        devTypeFuncEntity.setCreateTime(new Date());
        devTypeFuncEntity.setDevTypeId(addDevTypeFuncReq.getDevTypeId());
        devTypeFuncEntity.setCategoryId(addDevTypeFuncReq.getCategoryId());
        devTypeFuncEntity.setFuncId(addDevTypeFuncReq.getFuncId());
        baseMapper.insert(devTypeFuncEntity);
    }


    @Override
    public void update(UpdateDevTypeFuncReq updateDevTypeFuncReq) {
        DevTypeFuncEntity devTypeFuncEntity = baseMapper.selectById(updateDevTypeFuncReq.getId());
        if (devTypeFuncEntity != null) {
            devTypeFuncEntity.setName(updateDevTypeFuncReq.getName());
            devTypeFuncEntity.setParams(updateDevTypeFuncReq.getParams());
            devTypeFuncEntity.setUpdateTime(new Date());
            baseMapper.updateById(devTypeFuncEntity);
        }
    }

    @Override
    public DevTypeFuncEntity findByID(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void deleteById(Long id) {
        baseMapper.deleteById(id);
    }

}
