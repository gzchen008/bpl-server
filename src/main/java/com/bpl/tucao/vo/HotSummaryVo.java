package com.bpl.tucao.vo;

/**
 * @author cuiyongdai
 * @desc
 * @date 2017/8/10 0010.
 */
public class HotSummaryVo {

    private Integer id;
    private String content;
    private String hotCount;
    private Integer likeFlag;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHotCount() {
        return hotCount;
    }

    public void setHotCount(String hotCount) {
        this.hotCount = hotCount;
    }

    public Integer getLikeFlag() {
        return likeFlag;
    }

    public void setLikeFlag(Integer likeFlag) {
        this.likeFlag = likeFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
