package io.iotmp.modules.sys.vo.request;

import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/10/13 11:37
 * @Version 1.0
 **/
@Data
public class FinishWorkOrderReq {
    private Long id;
    private String finishRemark;
    private String userName;
}
