package io.iotmp.modules.manage.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/29 11:11
 * @Version 1.0
 **/
@Data
@ApiModel(description = "添加方法请求")
public class UpdateProSystemReq {
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
    @ApiModelProperty(value = "机构Id", required = true)
    private Integer orgId;
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "字典ID")
    private Integer categoryId;

}
