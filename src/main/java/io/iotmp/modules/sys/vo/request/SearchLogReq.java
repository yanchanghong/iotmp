package io.iotmp.modules.sys.vo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/17 20:44
 * @Version 1.0
 **/
@Data
@ApiModel(description = "日志查询请求")
public class SearchLogReq {
    private Long startTime;
    private Long endTime;
    private Integer type;
    @ApiParam(value = "当前页数", required = true, defaultValue = "1")
    private Long page;
    @ApiParam(value = "每页数量", required = true, defaultValue = "10")
    private Long pageSize;
}
