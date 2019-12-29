package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysDeviceDao;
import io.iotmp.modules.manage.entity.DeviceEntity;
import io.iotmp.modules.manage.service.DeviceService;

import io.iotmp.modules.manage.vo.request.AddDeviceReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.UpdateDeviceReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("DeviceService")
@Slf4j
public class DeviceServiceImpl extends ServiceImpl<SysDeviceDao, DeviceEntity> implements DeviceService {
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

}
