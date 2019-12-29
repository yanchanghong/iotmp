package io.iotmp.modules.manage.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/22 11:11
 * @Version 1.0
 **/
@Data
@ApiModel(description = "添加方法请求")
public class AddProSystemReq {
    @ApiModelProperty(value = "机构Id", required = true)
    private Integer orgId;
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "字典ID",required = true)
    private Integer categoryId;

}
