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
@ApiModel(description = "更新区域请求")
public class UpdateRegionReq {
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
    @ApiModelProperty(value = "类型，图片，2地图", required = true)
    private Integer type;
    @ApiModelProperty(value = "父类ID")
    private Integer parentId;
    @ApiModelProperty(value = "机构ID")
    private Integer orgId;
    @ApiModelProperty(value = "名称" , required = true)
    private String name;
    @ApiModelProperty(value = "背景图")
    private String url;
    @ApiModelProperty(value = "初始倍数")
    private Integer zoom;
    @ApiModelProperty(value = "经度")
    private String longitude;
    @ApiModelProperty(value = "纬度")
    private String latitude;

}
