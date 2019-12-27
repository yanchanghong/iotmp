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
 * @Date 2019/12/18 16:31
 * @Version 1.0
 **/
@Data
@TableName("sys_device_pic")
public class DevPicEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private String name;
    private Integer status;
    private String codes;
    private Date createTime;
    private Date updateTime;
}
