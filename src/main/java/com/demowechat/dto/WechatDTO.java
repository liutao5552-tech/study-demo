package com.demowechat.dto;

public class WechatDTO {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WechatDTO(String url) {
        this.url = url;
    }
}
