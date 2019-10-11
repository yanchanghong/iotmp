/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.form;

import lombok.Data;

/**
 * 登录表单
 *
 * @author changhong.yan
 * @Date 2019/10/02
 */
@Data
public class SysLoginForm {
    private String userName;
    private String passWord;
    private String orgCode;
    private String ip;


}
