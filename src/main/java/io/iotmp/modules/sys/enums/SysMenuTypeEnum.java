package io.iotmp.modules.sys.enums;

/**
 * @ClassName
 * @Description
 * @Author changhong.yan
 * @Date 2019/10/9 15:16
 * @Version 1.0
 **/
public enum SysMenuTypeEnum {
    Effective("Effective", "有效"), LIGHT("light", "照明系统"), VIDEO("video", "视频监控"), WIFI("wifi", "WIFI系统告警"),AIR("air", "空气质量"), LED("led", "LED管理");

    private String value;
    private String description;

    SysMenuTypeEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
