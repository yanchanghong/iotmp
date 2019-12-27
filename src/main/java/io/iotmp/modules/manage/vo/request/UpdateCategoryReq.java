package io.iotmp.modules.manage.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/18 17:58
 * @Version 1.0
 **/
@Data
@ApiModel(description = "更新请求")
public class UpdateCategoryReq {
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "标识ID")
    private Integer selfId;
    @ApiModelProperty(value = "ID")
    private Integer id;
    @ApiModelProperty(value = "点位对应类型，1可读，2可写，3可读可写")
    private Integer pointType;
}
