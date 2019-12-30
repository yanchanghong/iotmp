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
public class UpdateDevTypeFuncReq {
    @ApiModelProperty(value = "ID", required = true)
    private Integer id;
    @ApiModelProperty(value = "方法名称", required = true)
    private String name;
    @ApiModelProperty(value = "方法参数", required = true)
    private String params;
}
