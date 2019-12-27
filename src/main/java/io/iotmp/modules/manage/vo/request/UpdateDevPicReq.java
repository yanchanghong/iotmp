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
@ApiModel(description = "添加图例请求")
public class UpdateDevPicReq {
    @ApiModelProperty(value = "状态，0关闭，1运行，2告警，2异常")
    private Integer status;
    @ApiModelProperty(value = "名称", required = true)
    private String name;
    @ApiModelProperty(value = "样式编码", required = true)
    private String codes;
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
