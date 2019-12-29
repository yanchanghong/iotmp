package io.iotmp.modules.manage.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.manage.service.FuncService;
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
@Api(tags = "方法管理")
@RequestMapping(value = "/api/v1/config/func")
public class SysFuncController {

    @Autowired
    private FuncService funcService;

    @ApiOperation(value = "获取方法列表", notes = "获取方法列表")
    @ResponseBody
    @GetMapping("/")
    public R list(SearchPageReq searchPageReq) {
        return R.ok().put("data", funcService.queryPage(searchPageReq));
    }

    @ApiOperation(value = "添加方法", notes = "添加方法")
    @ResponseBody
    @PostMapping("/add")
    public R add(@RequestBody AddFuncReq addFuncReq) {
        funcService.add(addFuncReq);
        return R.ok();
    }

    @ApiOperation(value = "修改方法", notes = "修改方法")
    @ResponseBody
    @PostMapping("/update")
    public R update(@RequestBody UpdateFuncReq updateFuncReq) {
        funcService.update(updateFuncReq);
        return R.ok();
    }

    @ApiOperation(value = "获取方法", notes = "通过ID获取方法")
    @ResponseBody
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        return R.ok().put("data", funcService.getById(id));
    }

    @ApiOperation(value = "删除方法", notes = "通过ID删除方法")
    @ResponseBody
    @PostMapping("/{id}")
    public R deleteById(@PathVariable("id") @ApiParam(name = "id", value = "id") Integer id) {
        funcService.deleteById(id);
        return R.ok();
    }
}
