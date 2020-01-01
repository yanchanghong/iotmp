package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.DevGroupService;
import io.iotmp.modules.manage.service.PointGroupService;
import io.iotmp.modules.manage.vo.request.*;
import io.iotmp.modules.manage.vo.response.GroupPicResp;
import io.iotmp.modules.manage.vo.response.PointGroupStyleResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 点位分组
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/11 15:47
 * @Version 1.0
 **/
@RestController
@Api(tags = "展示配置(点位分组)")
@RequestMapping(value = "/api/v1/config/project/pointGroup")
@Slf4j
public class SysPointGroupController {

    @Autowired
    private PointGroupService pointGroupService;

    @ApiOperation(value = "获取子设备类别下得点位分组", notes = "根据设备类别编号获取点位分组")
    @ResponseBody
    @GetMapping("/list")
    public R list(SearchpointGroupReq searchpointGroupReq) {
        return R.ok().put("data", pointGroupService.queryList(searchpointGroupReq));
    }

    @ApiOperation(value = "添加点位分组", notes = "添加点位分组")
    @ResponseBody
    @PostMapping("/add")
    public R add(@RequestBody AddPointGroupReq addPointGroupReq) {
        pointGroupService.add(addPointGroupReq);
        return R.ok();
    }

    @ApiOperation(value = "给点位分组添加点位类型", notes = "给点位分组添加点位类型")
    @ResponseBody
    @PostMapping("/pointGroup/add")
    public R add(@RequestBody AddPointGroupRelReq addPointGroupRelReq) {
        pointGroupService.bindCategory(addPointGroupRelReq);
        return R.ok();
    }

    @ApiOperation(value = "修改点位分组", notes = "修改点位分组")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdatePointGroupReq updatePointGroupReq) {
        pointGroupService.update(updatePointGroupReq);
        return R.ok();
    }

    @ApiOperation(value = "获取点位分组", notes = "通过ID获取点位分组")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        return R.ok().put("data", pointGroupService.findByID(id));
    }

    @ApiOperation(value = "删除设备分组", notes = "通过ID删除设备分组")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        pointGroupService.deleteById(id);
        return R.ok();
    }

    @ApiOperation(value = "解绑分组与点位字典关系", notes = "通过ID解绑关系")
    @ResponseBody
    @PostMapping("/unbind/{id}")
    public R unbind(@PathVariable("id") @ApiParam(name = "id", value = "id") Integer id) {
        pointGroupService.unbind(id);
        return R.ok();
    }

    @ApiOperation(value = "获取样式列表", notes = "返回样式列表")
    @ResponseBody
    @GetMapping("/styles")
    public R listStyles() {
        List<PointGroupStyleResp> list = new ArrayList<PointGroupStyleResp>();
        PointGroupStyleResp place1 = new PointGroupStyleResp();
        place1.setName("样式1");
        place1.setId(1);
        list.add(place1);
        PointGroupStyleResp place2 = new PointGroupStyleResp();
        place2.setName("样式2");
        place2.setId(2);
        list.add(place2);
        return R.ok().put("data", list);
    }
}


