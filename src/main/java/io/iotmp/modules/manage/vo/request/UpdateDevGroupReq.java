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
@ApiModel(description = "更新设备分组请求")
public class UpdateDevGroupReq {
    @ApiModelProperty(value = "字典ID", required = true)
    private Integer sysCategoryId;
    @ApiModelProperty(value = "分组图标", required = true)
    private String type;
    @ApiModelProperty(value = "分组图标路径")
    private String url;
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
