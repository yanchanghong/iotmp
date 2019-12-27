package io.iotmp.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.R;
import io.iotmp.modules.sys.entity.SysAlarmEntity;
import io.iotmp.modules.sys.vo.response.DeviceInfoResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/20 21:02
 * @Version 1.0
 **/
@RestController
@Api(tags = "设备管理")
@RequestMapping(value = "/api/v1/device", produces = MediaType.APPLICATION_JSON_VALUE)
public class SysDeviceController {

    @ApiOperation(value = "获取设备列表", notes = "根据设备名称查询设备列表")
    @ResponseBody
    @GetMapping("/devices/{orgId}/{regionId}")
    public R listDevices(@PathVariable("orgId") @ApiParam(name = "orgId", value = "机构ID", required = true) Long orgId, @PathVariable("regionId") @ApiParam(name = "regionId", value = "区域ID", required = true) Long regionId, @RequestParam(name = "deviceType", required = false) @ApiParam(value = "设备类型") String deviceType, @RequestParam(name = "deviceName", required = false) @ApiParam(value = "设备名称") String deviceName) {
        IPage<DeviceInfoResp> iPage = new Page<>();
        DeviceInfoResp deviceLightResp = new DeviceInfoResp();
        deviceLightResp.setDeviceName("照明1");
        deviceLightResp.setStatus("open");
        deviceLightResp.setDeviceType("智能型21");
        deviceLightResp.setLongitude(104.07);
        deviceLightResp.setLatitude(30.67);
        deviceLightResp.setDeviceId(1L);
        deviceLightResp.setRegionName("区域A");
        List<DeviceInfoResp> list = new ArrayList<DeviceInfoResp>();
        list.add(deviceLightResp);
        iPage.setRecords(list);
        PageUtils pageUtils = new PageUtils(iPage);
        return R.ok().put("data", pageUtils);
    }
}
