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
 * @Author canoelu
 * @Date 2019/12/18 16:31
 * @Version 1.0
 **/
@Data
@TableName("sys_region")
public class RegionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private Integer orgId;// 项目ID
    private Integer parentId;// 父ID
    private String name;// 名称
    private String url; // 背景图
    private String longitude;// 经度
    private String latitude;// 纬度
    private Integer zoom;// 初始倍数
    private Integer type;// 类型 1:图片，2：地图
    private Date createTime;
    private Date updateTime;
    @TableField(exist = false)
    private List<RegionEntity> children; //节点集合
    @TableField(exist = false)
    private Boolean hasChildren;
}
