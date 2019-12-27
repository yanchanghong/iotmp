/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录表单
 *
 * @author changhong.yan
 * @Date 2019/10/02
 */
@Data
@ApiModel(description = "用户登录请求")
public class SysLoginForm {
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "密码")
    private String passWord;
    @ApiModelProperty(value = "机构编码")
    private String orgCode;
    @ApiModelProperty(value = "登录客户端IP")
    private String ip;
}
