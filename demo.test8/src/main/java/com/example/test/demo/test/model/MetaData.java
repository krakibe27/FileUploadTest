package com.example.test.demo.test.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity class Mapped to the database columns

@Entity
@Table(name = "files_upload")
public class MetaData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // create unique id with Auto Increment
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/** -- Properties -- */

	@Column(name = "fileContentType")
	private String fileContentType;

	@Column(name = "name")
	private String fileName;

	@Column(name = "size")
	private Long size;

	@Column(name = "fileData")
	private String fileData;

	public MetaData() {

	}

	public MetaData(String fileContentType, String fileName, Long size, String fileData) {
		super();
		this.fileContentType = fileContentType;
		this.fileName = fileName;
		this.size = size;
		this.fileData = fileData;
	}

	public String getFileData() {
		return fileData;
	}

	public void setFileData(String fileData) {
		this.fileData = fileData;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
