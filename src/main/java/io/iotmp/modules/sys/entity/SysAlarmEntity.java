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
 * 告警
 *
 * @author changhong.yan
 */
@Data
@TableName("sys_alarm")
public class SysAlarmEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    private String alarmArea;
    private String deviceType;
    private String deviceName;
    private String alarmContent;
    private String sysMenuType;
    private Date createTime;
    private Integer alarmLevel;
}
