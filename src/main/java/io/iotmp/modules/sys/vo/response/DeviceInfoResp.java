package io.iotmp.modules.sys.vo.response;

import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/17 17:03
 * @Version 1.0
 **/
@Data
public class DeviceInfoResp {
    private Long deviceId;
    private String deviceName;
    private String deviceIconUrl;
    private Double longitude;//经度
    private Double latitude;;
    private Double regionX;
    private Double regionY;
    private String status;
    private String deviceType;
    private String regionName;
}
