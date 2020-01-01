package io.iotmp.modules.manage.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/18 17:07
 * @Version 1.0
 **/
@Data
@ApiModel(description = "给点位分组添加点位类别请求")
public class AddPointGroupRelReq {
    @ApiModelProperty(value = "点位字典ID", required = true)
    private Integer categoryTypeId;
    @ApiModelProperty(value = "点位分组ID")
    private Integer pointGroupId;
}
