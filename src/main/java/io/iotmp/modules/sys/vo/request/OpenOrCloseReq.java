package io.iotmp.modules.sys.vo.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/17 21:37
 * @Version 1.0
 **/
@Data
public class OpenOrCloseReq {
    @ApiModelProperty(value = "设备ID")
    @ApiParam(value = "设备ID", required = true, defaultValue = "11")
    private Long deviceId;
    @ApiParam(value = "状态", required = true, defaultValue = "open")
    private String status;
}
