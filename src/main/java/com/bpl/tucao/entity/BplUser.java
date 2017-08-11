/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.bpl.tucao.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户Entity
 * @author bplteam
 * @version 2017-08-10
 */
public class BplUser extends DataEntity<BplUser> {
	
	private static final long serialVersionUID = 1L;
	private String openid;		// openid
	private String nickName;		// nick_name
	private String avatarUrl;		// avatar_url
	private Integer gender;		// gender
	private String country;		// country
	private String province;		// province
	private String city;		// city
	private Date createTime;		// create_time
	
	public BplUser() {
		super();
	}
	public BplUser( String nickName,String avatarUrl,Integer gender,
					String country,String province,String city) {
		super();
		this.nickName = nickName;
		this.avatarUrl = avatarUrl;
		this.gender = gender;
		this.country = country;
		this.province = province;
		this.city = city;
	}

	public BplUser(String id){
		super(id);
	}

	@Length(min=0, max=255, message="openid长度必须介于 0 和 255 之间")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Length(min=0, max=127, message="nick_name长度必须介于 0 和 127 之间")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Length(min=0, max=255, message="avatar_url长度必须介于 0 和 255 之间")
	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	@Length(min=0, max=32, message="country长度必须介于 0 和 32 之间")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Length(min=0, max=32, message="province长度必须介于 0 和 32 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=0, max=32, message="city长度必须介于 0 和 32 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}