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
@TableName("sys_sub_device")
public class SubDeviceEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private Integer orgId;// 项目ID
    private String name;// 名称
    private Integer devTypeId;// 子设备类别ID
    private Integer deviceId;// 父类ID
    private Date createTime;
    private Date updateTime;
}
