package io.iotmp.modules.sys.vo.request;

import lombok.Data;

import java.util.Date;

@Data
public class AlarmReq {
    private String alarmArea;
    private String deviceType;
    private Date searchDate;
}
