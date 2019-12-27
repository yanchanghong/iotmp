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
@ApiModel(description = "添加项目请求")
public class AddProjectReq {
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "标识", required = true)
    private String code;
    @ApiModelProperty(value = "图片路径", required = true)
    private String url;
}
