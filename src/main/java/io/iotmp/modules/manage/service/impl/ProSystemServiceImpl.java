package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysProSystemDao;
import io.iotmp.modules.manage.entity.ProSystemEntity;
import io.iotmp.modules.manage.service.ProSystemService;
import io.iotmp.modules.manage.vo.request.AddProSystemReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.UpdateProSystemReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("ProSystemService")
@Slf4j
public class ProSystemServiceImpl extends ServiceImpl<SysProSystemDao, ProSystemEntity> implements ProSystemService {
    @Override
    public PageUtils queryList(SearchPageReq searchProSystemReq) {

        if (searchProSystemReq.getPage() == null) {
            searchProSystemReq.setPage(1L);
        }
        if (searchProSystemReq.getPageSize() == null) {
            searchProSystemReq.setPageSize(10L);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("page", searchProSystemReq.getPage() + "");
        params.put("pageSize", searchProSystemReq.getPageSize() + "");
        IPage<ProSystemEntity> page = this.page(
                new Query<ProSystemEntity>().getPage(params),
                new QueryWrapper<ProSystemEntity>().eq("org_id", searchProSystemReq.getOrgId()).orderByDesc("create_time")
        );

        return new PageUtils(page);
    }

    @Override
    public void add(AddProSystemReq addProSystemReq) {
        ProSystemEntity proSystem = new ProSystemEntity();
        proSystem.setName(addProSystemReq.getName());
        proSystem.setOrgId(addProSystemReq.getOrgId());
        proSystem.setCategoryId(addProSystemReq.getCategoryId());
        proSystem.setCreateTime(new Date());
        baseMapper.insert(proSystem);
    }


    @Override
    public void update(UpdateProSystemReq updateProSystemReq) {
        ProSystemEntity ProSystemEntity = baseMapper.selectById(updateProSystemReq.getId());
        if (ProSystemEntity != null) {
            ProSystemEntity.setName(updateProSystemReq.getName());
            baseMapper.updateById(ProSystemEntity);
        }
    }

    @Override
    public ProSystemEntity findByID(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void deleteById(Integer id) {
        baseMapper.deleteById(id);
    }

}
