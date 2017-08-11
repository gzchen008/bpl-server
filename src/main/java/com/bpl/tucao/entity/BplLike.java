/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.entity;

import com.bpl.tucao.dto.HotLikeDto;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 吐槽点赞表Entity
 * @author bpl
 * @version 2017-08-10
 */
public class BplLike extends DataEntity<BplLike> {
	
	private static final long serialVersionUID = 1L;
	private Integer hotid;		// hotid
	private Integer userid;		// userid
	private String nickName;		// nick_name
	private Date createTime;		// create_time
	private Date updateTime;		// update_time
	
	public BplLike() {
		super();
	}

	public BplLike(HotLikeDto hotLike) {
		this.hotid = hotLike.getHotId();
		this.userid = hotLike.getUserId();
		this.nickName = hotLike.getNickName();
	}

	public BplLike(String id){
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