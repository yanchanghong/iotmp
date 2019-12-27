

package io.iotmp.common.utils;

/**
 * Redis所有Keys
 *
 * @author Yanchanghong
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
