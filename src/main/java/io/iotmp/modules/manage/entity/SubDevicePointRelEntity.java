package io.iotmp.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author canoelu
 * @Date 2019/12/29 16:31
 * @Version 1.0
 **/
@Data
@TableName("sys_dev_point_rel")
public class SubDevicePointRelEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private Integer subDeviceId;// 子设备ID
    private Integer pointId;// 点位ID
    private Date createTime;
    private Date updateTime;
}
