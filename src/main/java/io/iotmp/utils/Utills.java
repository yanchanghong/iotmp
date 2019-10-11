package io.iotmp.utils;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @Author changhong.yan
 * @Date 2019/10/03
 * @Description 工具类
 */
public class Utills {

    public static String encodeDownloadFileName(HttpServletRequest request, String filename) throws UnsupportedEncodingException {
        String agent = request.getHeader("USER-AGENT");
        if (null != agent) {
            if (agent.contains("Firefox")) {//Firefox
                filename = "=?UTF-8?B?" + (new String(Base64.encodeBase64(filename.getBytes(StandardCharsets.UTF_8)))) + "?=";
            } else if (agent.contains("Chrome")) {//Chrome
                filename = new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            } else {//IE7+
                filename = URLEncoder.encode(filename, "UTF-8");
                filename = filename.replace("+", "%20");
            }
        }
        return filename;
    }
}
