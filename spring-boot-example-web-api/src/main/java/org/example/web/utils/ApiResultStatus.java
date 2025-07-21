package org.example.web.utils;

public enum ApiResultStatus {
    SUCCESS("success"),
    ERROR( "error");

    private String value;

    public String getValue() {
        return value;
    }

    ApiResultStatus(String value){
        this.value = value;
    }


}
