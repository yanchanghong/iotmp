package io.iotmp.modules.manage.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/25 14:24
 * @Version 1.0
 **/
@Data
@ApiModel(description = "列表查询请求")
public class SearchRegionReq {
    @ApiParam(value = "当前页数", required = true, defaultValue = "1")
    private Long page;
    @ApiParam(value = "每页数量", required = true, defaultValue = "10")
    private Long pageSize;
    @ApiParam(value = "项目ID", required = true)
    private Integer orgId;
    @ApiParam(value = "父类ID", required = true)
    private Integer parentId;
}
