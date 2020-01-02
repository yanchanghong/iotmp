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
@ApiModel(description = "绑定子设备点位请求")
public class AddSubDevicePointRelReq {
    @ApiModelProperty(value = "子设备ID", required = true)
    private Integer subDeviceId;
    @ApiModelProperty(value = "点位ID", required = true)
    private Integer pointId;
    @ApiModelProperty(value = "字典ID", required = true)
    private Integer categoryId;
}
