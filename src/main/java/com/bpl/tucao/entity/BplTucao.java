/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 吐槽流水记录Entity
 * @author bpl
 * @version 2017-08-10
 */
public class BplTucao extends DataEntity<BplTucao> {
	
	private static final long serialVersionUID = 1L;
	private String content;		// 内容
	private Integer userid;		// 用户ID
	private String nickName;		// 昵称
	private Integer gender;		// 性别
	private Integer hotid;		// 热点ID
	private Date createTime;		// 创建时间
	private Date updateTime;		// 更新时间
	private String flag;		// flag
	
	public BplTucao() {
		super();
	}

	public BplTucao(String id){
		super(id);
	}

	@Length(min=0, max=512, message="内容长度必须介于 0 和 512 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=127, message="昵称长度必须介于 0 和 127 之间")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Integer getHotid() {
		return hotid;
	}

	public void setHotid(Integer hotid) {
		this.hotid = hotid;
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
	
	@Length(min=0, max=11, message="flag长度必须介于 0 和 11 之间")
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}