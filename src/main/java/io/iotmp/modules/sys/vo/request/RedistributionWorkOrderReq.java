package io.iotmp.modules.sys.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/10/14 13:34
 * @Version 1.0
 **/

@Data
@ApiModel
public class RedistributionWorkOrderReq {
    @ApiModelProperty(value = "工单编号")
    private Long id;
    @ApiModelProperty(value = "运维人员")
    private String operationUser;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "工单描述")
    private String description;
}
