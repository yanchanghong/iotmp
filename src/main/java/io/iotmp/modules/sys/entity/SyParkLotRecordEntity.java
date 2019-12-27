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
 * 停车场进出记录表
 *
 * @author changhong.yan
 * @Date 2019/10/05
 */
@Data
@TableName("park_lot_record")
public class SyParkLotRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    private String platNumber;//车牌号
    private String region;
    private String doorWay;//入口
    private String inAndOut;//出口
    private Date createDate;
    private Date inTime;//进时间
    private Date outTime;//出时间
}
