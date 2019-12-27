package io.iotmp.modules.sys.vo.response;

import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/14 22:16
 * @Version 1.0
 **/
@Data
public class DeviceLightResp {
    private String deviceName;
    private Double energy;
}
