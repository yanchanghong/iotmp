package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.PointsService;
import io.iotmp.modules.manage.vo.request.AddPointsReq;
import io.iotmp.modules.manage.vo.request.SearchPageReq;
import io.iotmp.modules.manage.vo.request.SearchPointReq;
import io.iotmp.modules.manage.vo.request.UpdatePointsReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/27 15:47
 * @Version 1.0
 **/
@RestController
@Api(tags = "点位管理")
@RequestMapping(value = "/api/v1/config/project/points")
public class SysPointsController {

    @Autowired
    private PointsService PointsService;

    @ApiOperation(value = "获取点位列表", notes = "获取点位列表")
    @ResponseBody
    @GetMapping("/")
    public R list(SearchPointReq searchPointReq) {
        return R.ok().put("data", PointsService.queryPage(searchPointReq));
    }

    @ApiOperation(value = "添加点位", notes = "添加点位")
    @ResponseBody
    @PostMapping("/add")
    public R add(@RequestBody AddPointsReq addPointsReq) {
        PointsService.add(addPointsReq);
        return R.ok();
    }

    @ApiOperation(value = "修改点位", notes = "修改点位")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdatePointsReq updatePointsReq) {
        PointsService.update(updatePointsReq);
        return R.ok();
    }

    @ApiOperation(value = "获取点位", notes = "通过ID获取点位")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        return R.ok().put("data", PointsService.getById(id));
    }

    @ApiOperation(value = "删除点位", notes = "通过ID删除点位")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Integer id) {
        PointsService.deleteById(id);
        return R.ok();
    }
}
