package io.iotmp.modules.manage.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/22 11:11
 * @Version 1.0
 **/
@Data
@ApiModel(description = "添加子设备请求")
public class AddSubDeviceReq {
    @ApiModelProperty(value = "机构Id", required = true)
    private Integer orgId;
    @ApiModelProperty(value = "子设备名称", required = true)
    private String name;
    @ApiModelProperty(value = "子设备类别ID", required = true)
    private Integer devTypeId;
    @ApiModelProperty(value = "父类设备ID", required = true)
    private Integer deviceId;
}
