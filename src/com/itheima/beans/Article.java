package com.itheima.beans;

import java.util.Date;

/**
 * 博客文章实体类
 **/
public class Article {
	private Integer id; //文章标识 
	private String title; //文章标题 
	private String content; //文章内容 
	private Long totalReply; //回复数 
	private Date createTime; //发表时间 
	private String createPerson; //创建人  用于表征匿名功能
	private Date lastUpdateTime; //最后更新时间 
	private String lastUpdatePerson; //最后更新人 
	private Integer parentArticleId; //回复主题的编号 
	
	private String status;// "同意":1,"未同意":0   标识管理员是否审核过

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) { 
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getTotalReply() {
		return totalReply;
	}

	public void setTotalReply(Long totalReply) {
		this.totalReply = totalReply;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public String getLastUpdatePerson() {
		return lastUpdatePerson;
	}

	public void setLastUpdatePerson(String lastUpdatePerson) {
		this.lastUpdatePerson = lastUpdatePerson;
	}

	public Integer getParentArticleId() {
		return parentArticleId;
	}

	public void setParentArticleId(Integer parentArticleId) {
		this.parentArticleId = parentArticleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}	
