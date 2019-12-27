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
@ApiModel(description = "修改方法请求")
public class UpdateFuncReq {
    @ApiModelProperty(value = "类别：1设备，2点位")
    private Integer type;
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "标识", required = true)
    private String code;
    @ApiModelProperty(value = "方法模板", required = true)
    private String paramsTemplate;
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
