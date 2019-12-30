package io.iotmp.modules.manage.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/18 17:07
 * @Version 1.0
 **/
@Data
@ApiModel(description = "添加设备类别方法绑定请求")
public class AddDevTypeFuncReq {
    @ApiModelProperty(value = "设备类别ID", required = true)
    private Integer devTypeId;
    @ApiParam(value = "1设备类型，2子设备类型", required = true)
    private Integer type;
    @ApiModelProperty(value = "方法名称", required = true)
    private String name;
    @ApiModelProperty(value = "字典ID")
    private Integer categoryId;
    @ApiModelProperty(value = "方法参数", required = true)
    private String params;
    @ApiModelProperty(value = "方法ID", required = false)
    private Integer funcId;
}
