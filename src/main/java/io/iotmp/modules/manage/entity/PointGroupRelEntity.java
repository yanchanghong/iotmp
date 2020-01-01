package io.iotmp.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sys_point_group_rel")
public class PointGroupRelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private Integer categoryId;
    private Integer pointGroupId;
    private Date createTime;
    private Date updateTime;
}
