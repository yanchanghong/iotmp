package io.iotmp.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 点位管理
 * @Description
 * @Author canoelu
 * @Date 2019/12/27 16:31
 * @Version 1.0
 **/
@Data
@TableName("sys_points")
public class PointsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private Integer orgId;// 项目ID
    private String name;// 名称
    private String code;// 标识
    private String value; // 当前值
    private Date createTime;
    private Date updateTime;
}
