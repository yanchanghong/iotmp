package io.iotmp.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/12/29 21:13
 * @Version 1.0
 **/
@Data
@TableName("sys_dev_group")
public class DevGroupEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private Integer sysCategoryId;
    private String url;
    private String type;
    private Integer sysDevTypeId;
    private Date createTime;
    private Date updateTime;
    @TableField(exist = false)
    private String categoryName;
    @TableField(exist = false)
    private List<CategoryEntity> children;
}
