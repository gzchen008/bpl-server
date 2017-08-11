package com.bpl.tucao.vo;

/**
 * @author cuiyongdai
 * @desc
 * @date 2017/8/10 0010.
 */
public class HotFeedBackVo {

    private Integer id;
    private Integer status;
    private String content;
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
