package com.duoqio.cloud.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the document_info_tbl database table.
 * 
 */
@Entity
@Table(name="document_info_tbl")
public class DocumentInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="document_id")
	private Integer documentId;

	@Column(name="document_name")
	private String documentName;

	@Lob
	@Column(name="document_value")
	private String documentValue;

	public DocumentInfo() {
	}

	public Integer getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentValue() {
		return this.documentValue;
	}

	public void setDocumentValue(String documentValue) {
		this.documentValue = documentValue;
	}

}