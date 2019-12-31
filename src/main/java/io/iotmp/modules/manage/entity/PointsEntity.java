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

    /**
     *
     */
    @TableId
    private Integer id;
    /**
     * 点位编码
     */
    private String deviceCode;
    /**
     * 点位值
     */
    private String value;
    /**
     * 添加时间
     */
    private Date createTime;
    /**
     * 机构ID
     */
    private Integer orgId;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 名称
     */
    private String name;
    /**
     * 标识
     */
    private String code;

}

