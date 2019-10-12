/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 工单
 *
 * @author changhong.yan
 */
@Data
@TableName("sys_work_order")
public class SysWorkOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    private Long alarmId;
    private String orderId;
    private String auditorUser;
    private String operationUser;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private String title;
    private String dealAddress;
    private String description;
    private Date distributionTime;
    private Date refuseTime;
    private Date redistributionTime;
    private String refuseReson;
    private String remark;
    private Date completionTime;
    private Long parentId;
}
