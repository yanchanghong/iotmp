package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysDevPicDao;
import io.iotmp.modules.manage.entity.DevPicEntity;
import io.iotmp.modules.manage.service.DevPicService;
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
@Service("devPicService")
@Slf4j
public class DevPicServiceImpl extends ServiceImpl<SysDevPicDao, DevPicEntity> implements DevPicService {

    @Override
    public void add(AddDevPicReq addDevPicReq) {
        DevPicEntity devPicEntity = new DevPicEntity();
        devPicEntity.setName(addDevPicReq.getName());
        devPicEntity.setCodes(addDevPicReq.getCodes());
        devPicEntity.setStatus(addDevPicReq.getStatus());
        devPicEntity.setCreateTime(new Date());
        baseMapper.insert(devPicEntity);
    }

    @Override
    public String categoryCode(Long id) {
        String categoryCode = "<span class=\"point_span_{p_id_category_" + id + "}\">{p_value_category_" + id + "}</span><input type=\"text\" value=\"{p_value_category_" + id + "}\" class=\"point_input_{p_id_category_" + id + "}\" />";
        return categoryCode;
    }

    @Override
    public void update(UpdateDevPicReq updateDevPic) {
        DevPicEntity devPicEntity = new DevPicEntity();
        devPicEntity.setName(updateDevPic.getName());
        devPicEntity.setCodes(updateDevPic.getCodes());
        devPicEntity.setStatus(updateDevPic.getStatus());
        devPicEntity.setUpdateTime(new Date());
        devPicEntity.setId(updateDevPic.getId());
        baseMapper.updateById(devPicEntity);
    }

    @Override
    public void deleteById(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public PageUtils queryPage(SearchDevPicReq searchDevPicReq) {
        if (searchDevPicReq.getPage() == null) {
            searchDevPicReq.setPage(1L);
        }
        if (searchDevPicReq.getPageSize() == null) {
            searchDevPicReq.setPageSize(10L);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("page", searchDevPicReq.getPage() + "");
        params.put("pageSize", searchDevPicReq.getPageSize() + "");
        IPage<DevPicEntity> page = this.page(
                new Query<DevPicEntity>().getPage(params),
                new QueryWrapper<DevPicEntity>().orderByDesc("create_time")
        );
        return new PageUtils(page);
    }

    @Override
    public DevPicEntity getById(Integer id) {
        return baseMapper.selectById(id);
    }
}
