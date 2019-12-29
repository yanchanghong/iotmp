package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.exception.RRException;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SystemRegionDao;
import io.iotmp.modules.manage.entity.RegionEntity;
import io.iotmp.modules.manage.service.RegionService;
import io.iotmp.modules.manage.vo.request.AddRegionReq;
import io.iotmp.modules.manage.vo.request.SearchRegionReq;
import io.iotmp.modules.manage.vo.request.UpdateRegionReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service("RegionService")
@Slf4j
public class RegionServiceImpl extends ServiceImpl<SystemRegionDao, RegionEntity> implements RegionService {
    @Override
    public PageUtils queryList(SearchRegionReq searchRegionReq) {

        if (searchRegionReq.getPage() == null) {
            searchRegionReq.setPage(1L);
        }
        if (searchRegionReq.getPageSize() == null) {
            searchRegionReq.setPageSize(10L);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("page", searchRegionReq.getPage() + "");
        params.put("pageSize", searchRegionReq.getPageSize() + "");
        IPage<RegionEntity> page = this.page(
                new Query<RegionEntity>().getPage(params),
                new QueryWrapper<RegionEntity>().eq("parent_id", searchRegionReq.getParentId()).eq("org_id", searchRegionReq.getOrgId()).orderByDesc("create_time")
        );

        List<RegionEntity> sysRegionList = page.getRecords();
        for (RegionEntity Region : sysRegionList) {
            List<RegionEntity> devRegionList = baseMapper.selectList(new QueryWrapper<RegionEntity>().eq("parent_id", Region.getId()).orderByDesc("create_time"));
            Region.setChildren(devRegionList);
        }
        return new PageUtils(page);
    }

    @Override
    public void add(AddRegionReq addRegionReq) {
        RegionEntity Region = new RegionEntity();
        Region.setName(addRegionReq.getName());
        Region.setLatitude(addRegionReq.getLatitude());
        Region.setLongitude(addRegionReq.getLongitude());
        Region.setZoom(addRegionReq.getZoom());
        Region.setType(addRegionReq.getType());
        Region.setOrgId(addRegionReq.getOrgId());
        Region.setParentId(addRegionReq.getParentId());
        Region.setUrl(addRegionReq.getUrl());
        Region.setCreateTime(new Date());
        baseMapper.insert(Region);
    }


    private void checkSelfIdAndType(Integer selfId, Integer RegionType) {
        RegionEntity Region = baseMapper.selectOne((new QueryWrapper<RegionEntity>().eq("self_id", selfId).eq("Region_type_id", RegionType)));
        if (Region != null) {
            throw new RRException("标识ID有重复");
        }
    }

    @Override
    public void update(UpdateRegionReq updateRegionReq) {
        log.info("updateRegionreq:{}", updateRegionReq);
        RegionEntity RegionEntity = baseMapper.selectById(updateRegionReq.getId());
        if (RegionEntity != null) {


            RegionEntity.setName(updateRegionReq.getName());
            baseMapper.updateById(RegionEntity);
        }
    }

    @Override
    public RegionEntity findByID(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void deleteById(Long id) {
        baseMapper.deleteById(id);
    }

}
