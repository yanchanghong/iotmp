package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.FuncService;
import io.iotmp.modules.manage.service.ProjectService;
import io.iotmp.modules.manage.vo.request.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/11 15:47
 * @Version 1.0
 **/
@RestController
@Api(tags = "项目管理")
@RequestMapping(value = "/api/v1/config/project")
public class SysProjectController {

    @Autowired
    private ProjectService projectService;

    @ApiOperation(value = "获取项目列表", notes = "获取项目列表")
    @ResponseBody
    @GetMapping("")
    public R listProject(SearchPageReq searchPageReq) {
        return R.ok().put("data", projectService.queryPage(searchPageReq));
    }

    @ApiOperation(value = "添加项目", notes = "添加项目")
    @ResponseBody
    @PostMapping("/add")
    public R add(@RequestBody AddProjectReq addProjectReq) {
        projectService.add(addProjectReq);
        return R.ok();
    }

    @ApiOperation(value = "修改项目", notes = "修改项目")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdateProjectReq updateProjectReq) {
        projectService.update(updateProjectReq);
        return R.ok();
    }

    @ApiOperation(value = "获取项目", notes = "通过ID获取项目")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        return R.ok().put("data", projectService.getById(id));
    }

    @ApiOperation(value = "删除项目", notes = "通过ID删除项目")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Integer id) {
        projectService.deleteById(id);
        return R.ok();
    }
}
