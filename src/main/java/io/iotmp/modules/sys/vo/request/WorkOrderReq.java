package io.iotmp.modules.sys.vo.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/10/12 15:06
 * @Version 1.0
 **/

@Data
public class WorkOrderReq {
    @ApiParam(value = "状态", required = true, defaultValue = "6")
    private Integer status;//0拒绝。1已派发，2完成,全部6.
    @ApiParam(value = "关键字", defaultValue = "标题")
    private String keyword;
    @ApiParam(value = "当前页数", required = true, defaultValue = "1")
    private Long page;
    @ApiParam(value = "每页数量", required = true, defaultValue = "10")
    private Long pageSize;
}
