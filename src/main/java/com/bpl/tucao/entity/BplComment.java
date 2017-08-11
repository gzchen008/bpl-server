/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.entity;

import com.bpl.tucao.dto.HotCommentDto;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 吐槽评论Entity
 * @author bpl
 * @version 2017-08-10
 */
public class BplComment extends DataEntity<BplComment> {
	
	private static final long serialVersionUID = 1L;
	private Integer hotid;		// hotid
	private Integer userid;		// userid
	private String nickName;		// nick_name
	private String content;		// content
	private Date createTime;		// create_time
	private Date updateTime;		// update_time
	
	public BplComment() {
		super();
	}

	public BplComment(HotCommentDto hotCommentDto) {
		this.hotid = hotCommentDto.getHotId();
		this.userid = hotCommentDto.getUserId();
		this.nickName = hotCommentDto.getNickName();
		this.content = hotCommentDto.getContent();
	}

	public BplComment(String id){
		super(id);
	}

	public Integer getHotid() {
		return hotid;
	}

	public void setHotid(Integer hotid) {
		this.hotid = hotid;
	}
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Length(min=0, max=512, message="content长度必须介于 0 和 512 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}