package io.iotmp.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/11/12 21:00
 * @Version 1.0
 **/
@Data
@TableName("sys_region")
public class SysRegionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Long orgId;
    private Long parentId;
    private Date createTime;
    private Date updateTime;
}
