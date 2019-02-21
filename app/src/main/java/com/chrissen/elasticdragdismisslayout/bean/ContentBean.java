package com.chrissen.elasticdragdismisslayout.bean;

import java.io.Serializable;

/**
 * Function:
 * <br/>
 * Describe:
 * <br/>
 * Author: chris on 2019/2/21.
 * <br/>
 * Email: chrissen0814@gmail.com
 */

public class ContentBean implements Serializable {

    private String mImageUrl;
    private String mContent;

    public ContentBean(String imageUrl, String content) {
        mImageUrl = imageUrl;
        mContent = content;
    }

    public String getImageUrl() {
        return mImageUrl == null ? "" : mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getContent() {
        return mContent == null ? "" : mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }
}
