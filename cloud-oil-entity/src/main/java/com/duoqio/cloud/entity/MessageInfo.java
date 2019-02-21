package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the message_info_tbl database table.
 * 
 */
@Entity
@Table(name="message_info_tbl")
@NamedEntityGraph(name = "MessageInfo.lazy", attributeNodes = {@NamedAttributeNode("messageTypeInfoTbl")})
public class MessageInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="message_id")
	private Integer messageId;

	@Column(name="message_context")
	private String messageContext;

	@Column(name="message_delete_flag")
	private Short messageDeleteFlag;

	@Column(name="message_read_status")
	private Short messageReadStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="message_time")
	private Date messageTime;

	//bi-directional many-to-one association to MessageTypeInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="message_type_id")
	private MessageTypeInfo messageTypeInfoTbl;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private UserInfo userInfoTbl;

	public MessageInfo() {
	}

	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessageContext() {
		return this.messageContext;
	}

	public void setMessageContext(String messageContext) {
		this.messageContext = messageContext;
	}

	public Short getMessageDeleteFlag() {
		return this.messageDeleteFlag;
	}

	public void setMessageDeleteFlag(Short messageDeleteFlag) {
		this.messageDeleteFlag = messageDeleteFlag;
	}

	public Short getMessageReadStatus() {
		return this.messageReadStatus;
	}

	public void setMessageReadStatus(Short messageReadStatus) {
		this.messageReadStatus = messageReadStatus;
	}

	public Date getMessageTime() {
		return this.messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public MessageTypeInfo getMessageTypeInfoTbl() {
		return this.messageTypeInfoTbl;
	}

	public void setMessageTypeInfoTbl(MessageTypeInfo messageTypeInfoTbl) {
		this.messageTypeInfoTbl = messageTypeInfoTbl;
	}

	public UserInfo getUserInfoTbl() {
		return this.userInfoTbl;
	}

	public void setUserInfoTbl(UserInfo userInfoTbl) {
		this.userInfoTbl = userInfoTbl;
	}

}