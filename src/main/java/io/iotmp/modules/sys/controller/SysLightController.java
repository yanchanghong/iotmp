package io.iotmp.modules.sys.controller;

import io.iotmp.common.utils.PageUtils;
import io.iotmp.common.utils.R;
import io.iotmp.modules.sys.service.SysLightService;
import io.iotmp.modules.sys.vo.request.OpenOrCloseReq;
import io.iotmp.modules.sys.vo.response.DeviceInfoResp;
import io.iotmp.modules.sys.vo.response.DeviceLightResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/12 20:14
 * @Version 1.0
 **/
@RestController
@Api(tags = "照明控制")
@RequestMapping(value = "/api/v1/light", produces = MediaType.APPLICATION_JSON_VALUE)
public class SysLightController {
    @Autowired
    private SysLightService sysLightService;

    @ApiOperation(value = "能耗排名")
    @ResponseBody
    @GetMapping("/top")
    public R top(@RequestParam(required = true) @ApiParam(name = "orgId", value = "机构ID") Long orgId, @RequestParam(required = true) @ApiParam(name = "regionId", value = "区域ID") Long regionId) {
        List<DeviceLightResp> deviceLightResps = new ArrayList<DeviceLightResp>();
        DeviceLightResp deviceLightResp = new DeviceLightResp();
        deviceLightResp.setDeviceName("5#未来之星灯杆1");
        deviceLightResp.setEnergy(10.2d);
        DeviceLightResp deviceLightResp1 = new DeviceLightResp();
        deviceLightResp1.setDeviceName("5#未来之星灯杆2");
        deviceLightResp1.setEnergy(10.2d);
        deviceLightResps.add(deviceLightResp);
        deviceLightResps.add(deviceLightResp1);
        DeviceLightResp deviceLightResp2 = new DeviceLightResp();
        deviceLightResp2.setDeviceName("5#未来之星灯杆3");
        deviceLightResp2.setEnergy(10.2d);
        DeviceLightResp deviceLightResp3 = new DeviceLightResp();
        deviceLightResp3.setDeviceName("5#未来之星灯杆4");
        deviceLightResp3.setEnergy(10.2d);
        deviceLightResps.add(deviceLightResp2);
        deviceLightResps.add(deviceLightResp3);
        DeviceLightResp deviceLightResp4 = new DeviceLightResp();
        deviceLightResp4.setDeviceName("5#未来之星灯杆5");
        deviceLightResp4.setEnergy(10.2d);
        DeviceLightResp deviceLightResp5 = new DeviceLightResp();
        deviceLightResp1.setDeviceName("5#未来之星灯杆6");
        deviceLightResp1.setEnergy(10.2d);
        deviceLightResps.add(deviceLightResp4);
        deviceLightResps.add(deviceLightResp5);
        DeviceLightResp deviceLightResp6 = new DeviceLightResp();
        deviceLightResp6.setDeviceName("5#未来之星灯杆7");
        deviceLightResp6.setEnergy(10.2d);
        DeviceLightResp deviceLightResp7 = new DeviceLightResp();
        deviceLightResp7.setDeviceName("5#未来之星灯杆8");
        deviceLightResp7.setEnergy(10.2d);
        deviceLightResps.add(deviceLightResp6);
        deviceLightResps.add(deviceLightResp7);
        DeviceLightResp deviceLightResp8 = new DeviceLightResp();
        deviceLightResp8.setDeviceName("5#未来之星灯杆9");
        deviceLightResp8.setEnergy(10.2d);
        DeviceLightResp deviceLightResp9 = new DeviceLightResp();
        deviceLightResp9.setDeviceName("5#未来之星灯杆10");
        deviceLightResp9.setEnergy(10.2d);
        deviceLightResps.add(deviceLightResp8);
        deviceLightResps.add(deviceLightResp9);
        return R.ok().put("data", deviceLightResps);
    }

    @ApiOperation(value = "总耗能量")
    @ResponseBody
    @GetMapping("/total")
    public R totalEnergy(@RequestParam(required = false, value = "orgId") @ApiParam(value = "机构ID") Long orgId, @RequestParam(required = false, value = "regionId") @ApiParam(value = "区域ID") Long regionId, @RequestParam(required = false, value = "status") @ApiParam(value = "状态") String status) {
        //return R.ok().put("data", sysLightService.totalEnergy(orgId, regionId, status));
        return R.ok().put("data", 678.12);
    }

    @ApiOperation(value = "设备数量", notes = "按照状态统计设备")
    @ResponseBody
    @GetMapping("/totalDevice")
    public R totalDevice(@RequestParam(required = false) @ApiParam(name = "orgId", value = "机构ID") Long orgId, @RequestParam @ApiParam(required = true, name = "regionId", value = "区域ID") Long regionId) {
        Map<String, Object> params = new HashMap<>();
        params.put("runAmount", 900);
        params.put("closeAmount", 10);
        params.put("alertAmount", 5);
        return R.ok().put("data", params);
    }

    @ApiOperation(value = "获取地图中的设备位置信息", notes = "根据区域ID或者状态显示设备")
    @GetMapping("/map/deviceInfos/{orgId}/{regionId}")
    public R getDeviceInfosForMap(@PathVariable("orgId") @ApiParam(name = "orgId", value = "机构ID", required = true) Long orgId, @PathVariable("regionId") @ApiParam(name = "regionId", value = "区域ID", required = true) Long regionId, @RequestParam(name = "status", required = false) @ApiParam(value = "状态") String status) {
        DeviceInfoResp deviceLightResp = new DeviceInfoResp();
        deviceLightResp.setDeviceName("照明1");
        deviceLightResp.setStatus("open");
        deviceLightResp.setDeviceType("智能型21");
        deviceLightResp.setLongitude(104.07);
        deviceLightResp.setLatitude(30.67);
        deviceLightResp.setDeviceId(1L);
        List<DeviceInfoResp> list = new ArrayList<DeviceInfoResp>();
        list.add(deviceLightResp);
        return R.ok().put("data", list);
    }

    @ApiOperation(value = "对设备开启或者关闭", notes = "根据设备ID开启或者关闭")
    @PostMapping("/openOrClose")
    public R openOrClose(@Valid @RequestBody OpenOrCloseReq openOrClose) {
        return R.ok();
    }
}
