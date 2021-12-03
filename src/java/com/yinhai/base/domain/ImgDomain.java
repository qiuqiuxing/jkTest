package com.yinhai.base.domain;

import java.io.Serializable;

/**
 * 图片对象类
 * @createTime 2021年04月15日 13:36:00
 */
public class ImgDomain implements Serializable {
    private String name;
    private String type;
    private String size;
    private String base64;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
