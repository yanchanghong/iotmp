package io.iotmp.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2020/1/3 16:55
 * @Version 1.0
 **/
@Data
@TableName("sys_system_dev_rel")
public class SystemDevRelEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private Integer systemId;
    private Integer deviceId;
    private Integer regionId;
    private Integer devPicId;
    private String longitude;//经度
    private String latitude;
    private String axisX;
    private String axisY;
    private Integer type; //1.地图，2背景图
    private Date createTime;
    private Date updateTime;
    @TableField(exist = false)
    private String deviceName;
    @TableField(exist = false)
    private String picCodes;
}
