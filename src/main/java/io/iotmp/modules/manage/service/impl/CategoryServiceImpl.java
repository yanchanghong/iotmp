package io.iotmp.modules.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.iotmp.common.exception.RRException;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.Query;
import io.iotmp.modules.manage.dao.SysCategoryDao;
import io.iotmp.modules.manage.entity.CategoryEntity;
import io.iotmp.modules.manage.service.CategoryService;
import io.iotmp.modules.manage.vo.request.AddCategoryReq;
import io.iotmp.modules.manage.vo.request.SearchCategoryReq;
import io.iotmp.modules.manage.vo.request.UpdateCategoryReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/18 16:50
 * @Version 1.0
 **/
@Service("categoryService")
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<SysCategoryDao, CategoryEntity> implements CategoryService {
    @Override
    public PageUtils queryList(SearchCategoryReq searchCategoryReq) {

        if (searchCategoryReq.getPage() == null) {
            searchCategoryReq.setPage(1L);
        }
        if (searchCategoryReq.getPageSize() == null) {
            searchCategoryReq.setPageSize(10L);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("page", searchCategoryReq.getPage() + "");
        params.put("pageSize", searchCategoryReq.getPageSize() + "");
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>().eq("category_type_id", 1).orderByDesc("create_time")
        );
        List<CategoryEntity> sysCategoryList = page.getRecords();
        for (CategoryEntity category : sysCategoryList) {
            List<CategoryEntity> devCategoryList = baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_id", category.getId()).orderByDesc("create_time"));
            category.setChildren(devCategoryList);
            for (CategoryEntity devCategory : devCategoryList) {
                List<CategoryEntity> pointCategoryList = baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_id", devCategory.getId()).orderByDesc("create_time"));
                devCategory.setChildren(pointCategoryList);
            }
        }
        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> queryListByType(Integer categoryTypeId) {
        return baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("category_type_id", categoryTypeId).orderByDesc("create_time"));
    }

    @Override
    public void add(AddCategoryReq addCategoryReq) {
        CategoryEntity category = new CategoryEntity();
        if (addCategoryReq.getCategoryTypeId().intValue() == 1) {
            category.setName(addCategoryReq.getName());
            category.setSelfId(addCategoryReq.getSelfId());
            category.setParentId(0);
            category.setCreateTime(new Date());
            category.setCategoryTypeId(1);
        } else if (addCategoryReq.getCategoryTypeId().intValue() == 2) {
            category.setName(addCategoryReq.getName());
            category.setSelfId(addCategoryReq.getSelfId());
            category.setParentId(addCategoryReq.getParentId());
            category.setCreateTime(new Date());
            category.setCategoryTypeId(2);
        } else {
            category.setName(addCategoryReq.getName());
            category.setSelfId(addCategoryReq.getSelfId());
            category.setParentId(addCategoryReq.getParentId());
            category.setCreateTime(new Date());
            category.setCategoryTypeId(3);
            category.setPointType(addCategoryReq.getPointType());
        }
        checkNameAndType(category.getName(), category.getCategoryTypeId());
        checkSelfIdAndType(category.getSelfId(), category.getCategoryTypeId());
        baseMapper.insert(category);
    }

    private void checkNameAndType(String name, Integer categoryType) {
        CategoryEntity category = baseMapper.selectOne((new QueryWrapper<CategoryEntity>().eq("name", name).eq("category_type_id", categoryType)));
        if (category != null) {
            throw new RRException("名称有重复");
        }
    }

    private void checkSelfIdAndType(Integer selfId, Integer categoryType) {
        CategoryEntity category = baseMapper.selectOne((new QueryWrapper<CategoryEntity>().eq("self_id", selfId).eq("category_type_id", categoryType)));
        if (category != null) {
            throw new RRException("标识ID有重复");
        }
    }

    @Override
    public void update(UpdateCategoryReq updateCategoryReq) {
        log.info("updateCategoryreq:{}", updateCategoryReq);
        CategoryEntity categoryEntity = baseMapper.selectById(updateCategoryReq.getId());
        if (categoryEntity != null) {
            if (!updateCategoryReq.getName().equals(categoryEntity.getName())) {
                checkNameAndType(updateCategoryReq.getName(), categoryEntity.getCategoryTypeId());
            }
            if (updateCategoryReq.getSelfId().intValue() != categoryEntity.getSelfId().intValue()) {
                checkSelfIdAndType(updateCategoryReq.getSelfId(), categoryEntity.getCategoryTypeId());
            }
            categoryEntity.setName(updateCategoryReq.getName());
            categoryEntity.setSelfId(updateCategoryReq.getSelfId());
            categoryEntity.setPointType(updateCategoryReq.getPointType());
            baseMapper.updateById(categoryEntity);
        }
    }

    @Override
    public CategoryEntity findByID(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void deleteById(Long id) {
        CategoryEntity categoryEntity = baseMapper.selectById(id);
        if (categoryEntity.getCategoryTypeId().intValue() == 3) {
            baseMapper.deleteById(id);
        } else if (categoryEntity.getCategoryTypeId().intValue() == 2) {
            baseMapper.deleteById(id);
            List<CategoryEntity> categories = baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_id", categoryEntity.getId()));
            for (CategoryEntity category : categories) {
                baseMapper.deleteById(category.getId());
            }
        } else {
            baseMapper.deleteById(id);
            List<CategoryEntity> categories = baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_id", categoryEntity.getId()));
            for (CategoryEntity category : categories) {
                baseMapper.deleteById(category.getId());
                List<CategoryEntity> list = baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_id", category.getId()));
                for (CategoryEntity cat : list) {
                    baseMapper.deleteById(cat.getId());
                }
            }
        }
    }

    @Override
    public List<CategoryEntity> queryListById(Long id) {
        CategoryEntity categoryEntity = baseMapper.selectById(id);
        List<CategoryEntity> pointCategoryList = new ArrayList<>();
        if (categoryEntity != null) {
            if (categoryEntity.getCategoryTypeId().intValue() == 2) {
                pointCategoryList = baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_id", categoryEntity.getId()).orderByDesc("create_time"));
            }
        }
        return pointCategoryList;
    }
}
