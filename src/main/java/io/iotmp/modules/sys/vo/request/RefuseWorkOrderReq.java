package io.iotmp.modules.sys.vo.request;

import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/10/14 10:24
 * @Version 1.0
 **/
@Data
public class RefuseWorkOrderReq {
    private Long id;
    private String refuseReson;
    private String username;
}
