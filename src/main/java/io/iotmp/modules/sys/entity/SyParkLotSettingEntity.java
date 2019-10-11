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
 * 停车场设置
 *
 * @author changhong.yan
 * @Date 2019/10/05
 */
@Data
@TableName("park_lot_setting")
public class SyParkLotSettingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    private Integer total;
    private Integer residueNumber;
    private String charge;
    private Date createDate;
}
