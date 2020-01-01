package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysPointsDao;
import io.iotmp.modules.manage.entity.PointsEntity;
import io.iotmp.modules.manage.service.PointsService;
import io.iotmp.modules.manage.vo.request.AddPointsReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.UpdatePointsReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author canolu
 * @Date 2019/12/18 16:50
 * @Version 1.0
 **/
@Service("PointsService")
@Slf4j
public class PointsServiceImpl extends ServiceImpl<SysPointsDao, PointsEntity> implements PointsService {

    @Override
    public void add(AddPointsReq addPointsReq) {
        PointsEntity Points = new PointsEntity();
        Points.setName(addPointsReq.getName());
        Points.setOrgId(addPointsReq.getOrgId());
        Points.setCode(addPointsReq.getCode());
        Points.setValue(addPointsReq.getValue());
        Points.setCreateTime(new Date());
        baseMapper.insert(Points);
    }


    @Override
    public void update(UpdatePointsReq updatePointsReq) {
        PointsEntity Points = new PointsEntity();
        Points.setName(updatePointsReq.getName());
        Points.setCode(updatePointsReq.getCode());
        Points.setValue(updatePointsReq.getValue());
        Points.setId(updatePointsReq.getId());
        Points.setUpdateTime(new Date());
        baseMapper.updateById(Points);
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
        IPage<PointsEntity> page = this.page(
                new Query<PointsEntity>().getPage(params),
                new QueryWrapper<PointsEntity>().eq(searchPageReq.getOrgId() != null, "org_id", searchPageReq.getOrgId()).orderByDesc("create_time")
        );
        return new PageUtils(page);
    }

    @Override
    public PointsEntity getById(Integer id) {
        return baseMapper.selectById(id);
    }
}
