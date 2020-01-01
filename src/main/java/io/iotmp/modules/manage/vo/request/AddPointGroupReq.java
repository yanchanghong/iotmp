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
@ApiModel(description = "添加点位分组请求")
public class AddPointGroupReq {
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "样式类型")
    private Integer styleType;
    @ApiModelProperty(value = "设备类别ID", required = true)
    private Integer devTypeId;
}
