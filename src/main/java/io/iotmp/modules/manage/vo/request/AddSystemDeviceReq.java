package io.iotmp.modules.manage.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/1/3 17:07
 * @Version 1.0
 **/
@Data
@ApiModel(description = "系统中添加设备")
public class AddSystemDeviceReq {
    @ApiModelProperty(value = "系统Id", required = true)
    private Integer systemId;
    @ApiModelProperty(value = "设备ID", required = true)
    private Integer deviceId;
    @ApiModelProperty(value = "区域ID", required = true)
    private Integer regionId;
    @ApiModelProperty(value = "图列ID", required = true)
    private Integer devPicId;
}
