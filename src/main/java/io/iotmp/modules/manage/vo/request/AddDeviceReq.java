package io.iotmp.modules.manage.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/22 11:11
 * @Version 1.0
 **/
@Data
@ApiModel(description = "添加方法请求")
public class AddDeviceReq {
    @ApiModelProperty(value = "机构Id", required = true)
    private Integer orgId;
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "父类ID")
    private Integer parentId;
    @ApiModelProperty(value = "设备状态")
    private String status;
    @ApiModelProperty(value = "设备类别ID", required = true)
    private Integer devTypeId;

}
