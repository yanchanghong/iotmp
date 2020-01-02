package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysDeviceDao;
import io.iotmp.modules.manage.entity.*;
import io.iotmp.modules.manage.service.CategoryService;
import io.iotmp.modules.manage.service.DevGroupService;
import io.iotmp.modules.manage.service.DeviceService;

import io.iotmp.modules.manage.vo.request.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("DeviceService")
@Slf4j
public class DeviceServiceImpl extends ServiceImpl<SysDeviceDao, DeviceEntity> implements DeviceService {

    @Autowired
    private SysDeviceDao sysDeviceDao;

    @Autowired
    private DevGroupService devGroupService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public PageUtils queryList(SearchPageReq searchDeviceReq) {

        if (searchDeviceReq.getPage() == null) {
            searchDeviceReq.setPage(1L);
        }
        if (searchDeviceReq.getPageSize() == null) {
            searchDeviceReq.setPageSize(10L);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("page", searchDeviceReq.getPage() + "");
        params.put("pageSize", searchDeviceReq.getPageSize() + "");
        IPage<DeviceEntity> page = this.page(
                new Query<DeviceEntity>().getPage(params),
                new QueryWrapper<DeviceEntity>().eq("org_id", searchDeviceReq.getOrgId()).orderByDesc("create_time")
        );

        return new PageUtils(page);
    }

    @Override
    public void add(AddDeviceReq addDeviceReq) {
        DeviceEntity device = new DeviceEntity();
        device.setName(addDeviceReq.getName());
        device.setOrgId(addDeviceReq.getOrgId());
        device.setParentId(addDeviceReq.getParentId());
        device.setDevTypeId(addDeviceReq.getDevTypeId());
        device.setStatus(addDeviceReq.getStatus());
        device.setCreateTime(new Date());
        baseMapper.insert(device);
    }


    @Override
    public void update(UpdateDeviceReq updateDeviceReq) {
        DeviceEntity deviceEntity = baseMapper.selectById(updateDeviceReq.getId());
        if (deviceEntity != null) {
            deviceEntity.setName(updateDeviceReq.getName());
            baseMapper.updateById(deviceEntity);
        }
    }

    @Override
    public DeviceEntity findByID(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void deleteById(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public void addSubDev(AddSubDeviceReq addSubDeviceReq) {
        SubDeviceEntity subDeviceEntity = new SubDeviceEntity();
        subDeviceEntity.setName(addSubDeviceReq.getName());
        subDeviceEntity.setDevTypeId(addSubDeviceReq.getDevTypeId());
        subDeviceEntity.setDeviceId(addSubDeviceReq.getDeviceId());
        subDeviceEntity.setOrgId(addSubDeviceReq.getOrgId());
        subDeviceEntity.setCreateTime(new Date());
        sysDeviceDao.insertSubDevice(subDeviceEntity);
    }

    @Override
    public void bindPoint(AddSubDevicePointRelReq addSubDevicePointRelReq) {
        SubDevicePointRelEntity subDevicePointRelEntity = new SubDevicePointRelEntity();
        subDevicePointRelEntity.setSubDeviceId(addSubDevicePointRelReq.getSubDeviceId());
        subDevicePointRelEntity.setPointId(addSubDevicePointRelReq.getPointId());
        subDevicePointRelEntity.setCreateTime(new Date());
        subDevicePointRelEntity.setCategoryId(addSubDevicePointRelReq.getCategoryId());
        sysDeviceDao.insertSubDevicePointRel(subDevicePointRelEntity);
    }

    @Override
    public PageUtils querySubDeviceList(SearchSubDevicePageReq searchSubDevicePageReq) {
        SearchDevGroupReq searchDevGroupReq = new SearchDevGroupReq();
        searchDevGroupReq.setPageSize(searchSubDevicePageReq.getPageSize());
        searchDevGroupReq.setPage(searchSubDevicePageReq.getPage());
        searchDevGroupReq.setDevTypeId(searchSubDevicePageReq.getDeviceTypeId());
        PageUtils page = devGroupService.queryList(searchDevGroupReq);
        for (DevGroupEntity entity : (List<DevGroupEntity>) page.getList()) {
            List<SubDeviceEntity> subDeviceEntityList = sysDeviceDao.queryListByDeviceId(searchSubDevicePageReq.getDeviceId(), entity.getId());
            List<CategoryEntity> categories = categoryService.queryListById(Long.valueOf(entity.getSysCategoryId() + ""));
            for (SubDeviceEntity subDeviceEntity : subDeviceEntityList) {
                List<SubDevicePointRelEntity> subDevicePointRelEntityList = sysDeviceDao.getSubDevicePointRelList(subDeviceEntity.getId());
                for (SubDevicePointRelEntity subRel : subDevicePointRelEntityList) {
                    for (CategoryEntity categoryEntity : categories) {
                        SubDevicePointRelEntity subDevicePointRelEntity = sysDeviceDao.getSubDevicePointRel(subDeviceEntity.getId(), subRel.getPointId(), categoryEntity.getId());
                        if (subDevicePointRelEntity != null) {
                            categoryEntity.setIsBind(true);
                            categoryEntity.setPointName(subDevicePointRelEntity.getPointName());
                        }
                    }
                }
                subDeviceEntity.setCategorys(categories);
            }
            entity.setSubdevices(subDeviceEntityList);
        }
        return page;
    }
}
