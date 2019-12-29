package io.iotmp.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 项目内容-系统管理
 * @Description
 * @Author canoelu
 * @Date 2019/12/18 16:31
 * @Version 1.0
 **/
@Data
@TableName("sys_system")
public class ProSystemEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private Integer orgId;// 项目ID
    private Integer categoryId;// 字典ID
    private String name;// 名称
    private Date createTime;
    private Date updateTime;
}
