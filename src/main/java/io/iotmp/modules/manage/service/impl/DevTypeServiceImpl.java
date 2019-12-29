package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysDevTypeDao;
import io.iotmp.modules.manage.entity.DevTypeEntity;
import io.iotmp.modules.manage.service.DevTypeService;
import io.iotmp.modules.manage.vo.request.AddDevTypeReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.UpdateDevTypeReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("DevTypeService")
@Slf4j
public class DevTypeServiceImpl extends ServiceImpl<SysDevTypeDao, DevTypeEntity> implements DevTypeService {
    @Override
    public PageUtils queryList(SearchPageReq searchDevTypeReq) {

        if (searchDevTypeReq.getPage() == null) {
            searchDevTypeReq.setPage(1L);
        }
        if (searchDevTypeReq.getPageSize() == null) {
            searchDevTypeReq.setPageSize(10L);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("page", searchDevTypeReq.getPage() + "");
        params.put("pageSize", searchDevTypeReq.getPageSize() + "");
        IPage<DevTypeEntity> page = this.page(
                new Query<DevTypeEntity>().getPage(params),
                new QueryWrapper<DevTypeEntity>().eq("org_id", searchDevTypeReq.getOrgId()).orderByDesc("create_time")
        );

        return new PageUtils(page);
    }

    @Override
    public void add(AddDevTypeReq addDevTypeReq) {
        DevTypeEntity DevType = new DevTypeEntity();
        DevType.setName(addDevTypeReq.getName());
        DevType.setOrgId(addDevTypeReq.getOrgId());
        DevType.setCreateTime(new Date());
        baseMapper.insert(DevType);
    }


    @Override
    public void update(UpdateDevTypeReq updateDevTypeReq) {
        DevTypeEntity DevTypeEntity = baseMapper.selectById(updateDevTypeReq.getId());
        if (DevTypeEntity != null) {
            DevTypeEntity.setName(updateDevTypeReq.getName());
            baseMapper.updateById(DevTypeEntity);
        }
    }

    @Override
    public DevTypeEntity findByID(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void deleteById(Long id) {
        baseMapper.deleteById(id);
    }

}
