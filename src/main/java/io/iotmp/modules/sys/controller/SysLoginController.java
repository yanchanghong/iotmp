/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.iotmp.modules.sys.controller;

import io.iotmp.common.utils.R;
import io.iotmp.modules.sys.entity.SysLogEntity;
import io.iotmp.modules.sys.entity.SysUserEntity;
import io.iotmp.modules.sys.form.SysLoginForm;
import io.iotmp.modules.sys.service.SysCaptchaService;
import io.iotmp.modules.sys.service.SysLogService;
import io.iotmp.modules.sys.service.SysUserService;
import io.iotmp.modules.sys.service.SysUserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author changhong.yan
 * @Date 2019/10/02
 * @Description 登陆相关
 */
@Slf4j
@Api(description = "用户登陆接口")
@RestController
@RequestMapping(value = "/api/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class SysLoginController extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private SysCaptchaService sysCaptchaService;
    @Autowired
    private SysLogService sysLogService;

    /**
     * 验证码
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     */
    @ApiOperation(value = "用户登陆", notes = "根据用户相关信息登陆")
    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody SysLoginForm form, HttpServletRequest httpServletRequest) throws IOException {
        String ip = getIpAddress(httpServletRequest);
        String userAgent = httpServletRequest.getHeader("user-agent");
        log.info("ip:{}", ip);
        //用户信息
        SysUserEntity user = sysUserService.queryByUserName(form.getUserName());
        if (user == null) {
            return R.error("此账号不存在，请联系管理员");
        }
        //账号锁定
        if (user != null && user.getStatus() == 0) {
            return R.error("账号已被锁定,请联系管理员");
        }
        //账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassWord(), user.getSalt()).toHex())) {
            addFailNum(httpServletRequest.getSession(), user);
            return R.error("账号或密码不正确");
        }
        user.setPassword(null);
        user.setLoginTime(new Date());
        sysUserService.update(user);
        //登录日志
        SysLogEntity sysLogEntity = new SysLogEntity();
        sysLogEntity.setUsername(user.getUsername());
        sysLogEntity.setDept("");
        sysLogEntity.setCreateDate(new Date());
        sysLogEntity.setIp(ip);
        sysLogEntity.setType(0);
        sysLogEntity.setUserAgent(userAgent);
        sysLogEntity.setLoginTime(new Date());
        sysLogService.save(sysLogEntity);
        //生成token，并保存到数据库
        R r = sysUserTokenService.createToken(user.getUserId());
        r.put("userName", sysLogEntity.getUsername());
        r.put("orgCode", form.getOrgCode());
        return r;
    }

    /**
     * 用户登录失败次数
     *
     * @param session
     * @param user
     */
    private void addFailNum(HttpSession session, SysUserEntity user) {
        Object o = session.getServletContext().getAttribute(user.getUsername());
        HashMap<String, Object> map = null;
        int num = 0;
        if (o == null) {
            map = new HashMap<String, Object>();
        } else {
            map = (HashMap<String, Object>) o;
            num = (int) map.get("num");
            if (num >= 3) {
                user.setStatus(0);
                user.setPassword(null);
                sysUserService.update(user);
            }
        }
        map.put("num", num + 1);
        session.getServletContext().setAttribute(user.getUsername(), map);
    }

    /**
     * 退出
     */
    @PostMapping("/sys/logout")
    public R logout(HttpServletRequest httpServletRequest) throws Exception{
        String ip = getIpAddress(httpServletRequest);
        String userAgent = httpServletRequest.getHeader("user-agent");
        SysLogEntity sysLogEntity = new SysLogEntity();
        //sysLogEntity.setUsername(user.getUsername());
        sysLogEntity.setDept("");
        sysLogEntity.setCreateDate(new Date());
        sysLogEntity.setIp(ip);
        sysLogEntity.setType(0);
        sysLogEntity.setUserAgent(userAgent);
        sysLogEntity.setLogoutTime(new Date());
        sysLogService.save(sysLogEntity);
        sysUserTokenService.logout(getUserId());
        return R.ok();
    }

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     * @throws IOException
     */
    public final static String getIpAddress(HttpServletRequest request) throws IOException {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");
        if (log.isInfoEnabled()) {
            log.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (log.isInfoEnabled()) {
                    log.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (log.isInfoEnabled()) {
                    log.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (log.isInfoEnabled()) {
                    log.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (log.isInfoEnabled()) {
                    log.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (log.isInfoEnabled()) {
                    log.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
	
