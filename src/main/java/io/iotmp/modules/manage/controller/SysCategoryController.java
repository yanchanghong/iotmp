package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.CategoryService;
import io.iotmp.modules.manage.vo.request.AddCategoryReq;
import io.iotmp.modules.manage.vo.request.SearchCategoryReq;
import io.iotmp.modules.manage.vo.request.UpdateCategoryReq;
import io.iotmp.modules.manage.vo.response.PointTypeResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/11 15:47
 * @Version 1.0
 **/
@RestController
@Api(tags = "字典管理")
@RequestMapping(value = "/api/v1/config/category")
public class SysCategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取设备列表", notes = "根据设备名称查询设备列表")
    @ResponseBody
    @GetMapping("/")
    public R listCategory(SearchCategoryReq searchCategoryReq) {
        return R.ok().put("data", categoryService.queryList(searchCategoryReq));
    }

    @ApiOperation(value = "添加", notes = "添加系统，添加设备，添加点位")
    @ResponseBody
    @PostMapping("/add")
    public R add(@RequestBody AddCategoryReq addCategoryReq) {
        categoryService.add(addCategoryReq);
        return R.ok();
    }

    @ApiOperation(value = "修改字典", notes = "修改系统，修改设备，修改点位")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdateCategoryReq updateCategoryReq) {
        categoryService.update(updateCategoryReq);
        return R.ok();
    }

    @ApiOperation(value = "获取字典", notes = "通过ID获取字典")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        return R.ok().put("data", categoryService.findByID(id));
    }

    @ApiOperation(value = "删除字典", notes = "通过ID删除字典")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        categoryService.deleteById(id);
        return R.ok();
    }

    @ApiOperation(value = "获取点位类型列表", notes = "获取点位类型列表")
    @ResponseBody
    @GetMapping("/point/list")
    public R ListPointType() {
        List<PointTypeResp> list = new ArrayList<PointTypeResp>();
        PointTypeResp pointTypeResp1 = new PointTypeResp();
        pointTypeResp1.setTypeId(1);
        pointTypeResp1.setTypeName("系统");
        list.add(pointTypeResp1);
        PointTypeResp pointTypeResp2 = new PointTypeResp();
        pointTypeResp2.setTypeId(1);
        pointTypeResp2.setTypeName("系统");
        list.add(pointTypeResp2);
        PointTypeResp pointTypeResp3 = new PointTypeResp();
        pointTypeResp3.setTypeId(1);
        pointTypeResp3.setTypeName("系统");
        list.add(pointTypeResp3);
        return R.ok().put("data", list);
    }
}
