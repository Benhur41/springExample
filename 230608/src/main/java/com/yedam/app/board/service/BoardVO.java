package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardVO {
//	BNO
//	title
//	contents
//	WRITER
//	REGDATE
//	UPDATEDATE
//	IMAGE
	private String bno;
	private String title;
	private String contents;
	private String writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedate;
	private String image;
	
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", contents=" + contents + ", writer=" + writer
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + ", image=" + image + "]";
	}
	
}
