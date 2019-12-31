package io.iotmp.modules.manage.vo.response;

import io.iotmp.modules.manage.entity.CategoryEntity;
import lombok.Data;

import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/31 15:28
 * @Version 1.0
 **/
@Data
public class DevGroupResp {
    private String name;
    private Integer type;
    private Integer id;
    private List<CategoryEntity> children;
}
