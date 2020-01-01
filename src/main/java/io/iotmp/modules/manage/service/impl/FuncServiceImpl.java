package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysFuncDao;
import io.iotmp.modules.manage.entity.FuncEntity;
import io.iotmp.modules.manage.service.FuncService;
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
@Service("funcService")
@Slf4j
public class FuncServiceImpl extends ServiceImpl<SysFuncDao, FuncEntity> implements FuncService {

    @Override
    public void add(AddFuncReq addFuncReq) {
        FuncEntity func = new FuncEntity();
        func.setName(addFuncReq.getName());
        func.setCode(addFuncReq.getCode());
        func.setType(addFuncReq.getType());
        func.setParamsTemplate(addFuncReq.getParamsTemplate());
        func.setCreateTime(new Date());
        baseMapper.insert(func);
    }


    @Override
    public void update(UpdateFuncReq updateFuncReq) {
        FuncEntity func = new FuncEntity();
        func.setName(updateFuncReq.getName());
        func.setCode(updateFuncReq.getCode());
        func.setType(updateFuncReq.getType());
        func.setParamsTemplate(updateFuncReq.getParamsTemplate());
        func.setId(updateFuncReq.getId());
        func.setUpdateTime(new Date());
        baseMapper.updateById(func);
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
        IPage<FuncEntity> page = this.page(
                new Query<FuncEntity>().getPage(params),
                new QueryWrapper<FuncEntity>().eq(searchPageReq.getType() != null, "type", searchPageReq.getType()).orderByDesc("create_time")
        );
        return new PageUtils(page);
    }

    @Override
    public FuncEntity getById(Integer id) {
        return baseMapper.selectById(id);
    }
}
