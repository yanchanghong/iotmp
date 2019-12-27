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
@ApiModel(description = "添加字典请求")
public class AddCategoryReq {
    @ApiModelProperty(value = "字典类型，1系统，2设备，3点位")
    private Integer categoryTypeId;
    @ApiModelProperty(value = "父类ID")
    private Integer parentId;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "标识ID")
    private Integer selfId;
    @ApiModelProperty(value = "点位对应类型，1可读，2可写，3可读可写")
    private Integer pointType;
}
