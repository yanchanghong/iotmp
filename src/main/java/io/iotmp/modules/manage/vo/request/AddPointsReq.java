package io.iotmp.modules.manage.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/22 11:11
 * @Version 1.0
 **/
@Data
@ApiModel(description = "添加方法请求")
public class AddPointsReq {
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "标识", required = true)
    private String code;
    @ApiModelProperty(value = "当前值", required = true)
    private String value;
    @ApiModelProperty(value = "机构ID")
    private Integer orgId;
}
