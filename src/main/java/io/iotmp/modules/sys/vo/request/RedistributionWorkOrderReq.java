package io.iotmp.modules.sys.vo.request;

import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/10/14 13:34
 * @Version 1.0
 **/

@Data
public class RedistributionWorkOrderReq {
    private Long id;
    private String userName;
    private String operationUser;
    private String title;
    private String description;
}
