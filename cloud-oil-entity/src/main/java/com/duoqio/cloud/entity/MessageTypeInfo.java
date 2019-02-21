package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the message_type_info_tbl database table.
 * 
 */
@Entity
@Table(name="message_type_info_tbl")
public class MessageTypeInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="message_type_id")
	private Integer messageTypeId;

	@Column(name="message_type_delete_flag")
	private Short messageTypeDeleteFlag;

	@Column(name="message_type_name")
	private String messageTypeName;

	//bi-directional many-to-one association to MessageInfo
	@OneToMany(mappedBy="messageTypeInfoTbl")
	@JsonIgnore
	private List<MessageInfo> messageInfoTbls;

	public MessageTypeInfo() {
	}

	public Integer getMessageTypeId() {
		return this.messageTypeId;
	}

	public void setMessageTypeId(Integer messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public Short getMessageTypeDeleteFlag() {
		return this.messageTypeDeleteFlag;
	}

	public void setMessageTypeDeleteFlag(Short messageTypeDeleteFlag) {
		this.messageTypeDeleteFlag = messageTypeDeleteFlag;
	}

	public String getMessageTypeName() {
		return this.messageTypeName;
	}

	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}

	public List<MessageInfo> getMessageInfoTbls() {
		return this.messageInfoTbls;
	}

	public void setMessageInfoTbls(List<MessageInfo> messageInfoTbls) {
		this.messageInfoTbls = messageInfoTbls;
	}

	public MessageInfo addMessageInfoTbl(MessageInfo messageInfoTbl) {
		getMessageInfoTbls().add(messageInfoTbl);
		messageInfoTbl.setMessageTypeInfoTbl(this);

		return messageInfoTbl;
	}

	public MessageInfo removeMessageInfoTbl(MessageInfo messageInfoTbl) {
		getMessageInfoTbls().remove(messageInfoTbl);
		messageInfoTbl.setMessageTypeInfoTbl(null);

		return messageInfoTbl;
	}

}