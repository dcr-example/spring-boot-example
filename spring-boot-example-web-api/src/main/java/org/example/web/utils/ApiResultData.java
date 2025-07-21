package org.example.web.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ApiResultData {
    private String status;
    private String code;
    private String msg;
    private Object data;
    private Long timestamp;
    private String timestampFormat;

    private ApiResultData(){}

    private ApiResultData(String status, String code, String msg, Object data) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.data = data;
        LocalDateTime now = LocalDateTime.now(); // 获取当前日期和时间
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"); // 格式化为年月日时分秒毫秒
        this.timestampFormat = now.format(formatter);
        this.timestamp = zonedDateTime.toInstant().toEpochMilli(); // 获取时间戳


    }

    public ApiResultData(ApiResultCode resultCode, Object data, String msg) {
        this(resultCode.getResultStatus().getValue(),
                resultCode.getCode(),
                (StringUtils.isNotBlank(msg) ? msg : resultCode.getMsg()),
                data);
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    public Object getData() {
        return data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getTimestampFormat() {
        return timestampFormat;
    }

}
