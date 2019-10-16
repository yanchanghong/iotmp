package io.iotmp.modules.sys.vo.request;

import lombok.Data;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/10/12 18:28
 * @Version 1.0
 **/
@Data
public class AddWorkOrderReq {
    private String title;
    private String description;
    private String operationUser;
    private String auditorUser;
}
