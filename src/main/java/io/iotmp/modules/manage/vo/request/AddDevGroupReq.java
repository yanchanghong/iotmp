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
@ApiModel(description = "添加设备分组请求")
public class AddDevGroupReq {
    @ApiModelProperty(value = "字典ID", required = true)
    private Integer sysCategoryId;
    @ApiModelProperty(value = "分组图标类型", required = true)
    private String type;
    @ApiModelProperty(value = "分组图标路径")
    private String url;
    @ApiModelProperty(value = "设备类别ID", required = true)
    private Integer devTypeId;
}
