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
@TableName("sys_category")
public class CategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private String name;
    private Integer selfId;
    private Integer parentId;
    private Integer categoryTypeId;//1系统，2设备。3点位
    private Date createTime;
    private Date updateTime;
    private Integer pointType;//点位类型，1可读，2可写，3可读可写
    @TableField(exist = false)
    private List<CategoryEntity> children; //节点集合
}
