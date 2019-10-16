/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.vo.response;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统日志
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
@TableName("sys_log")
public class SysLoginLogResp implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    //用户名
    @Excel(name = "用户名")
    private String username;
    //用户操作
    private String operation;
    //请求方法
    private String method;
    //请求参数
    private String params;
    //执行时长(毫秒)
    private Long time;
    //IP地址
    @Excel(name = "ip")
    private String ip;
    //创建时间
    private Date createDate;
    //所属部门
    private String dept;
    //设备名称
    private String deviceName;
    //日志类型
    private Integer type;
    @Excel(name = "用户代理")
    private String userAgent;
    @Excel(name = "登录时间", format = "yyyy-mm-dd hh:mm:ss")
    private Date loginTime;
    @Excel(name = "登出时间", format = "yyyy-mm-dd hh:mm:ss")
    private Date logoutTime;
}
