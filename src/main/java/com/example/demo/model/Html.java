package com.example.demo.model;

import java.math.BigDecimal;
import oracle.jdbc.OracleClob;

public class Html {


	private int seq;
	private String subject;
	private String body;
	private String author;

	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public Html(BigDecimal seq, String subject, OracleClob body, String author) {
		this.seq = seq.intValue();
		this.subject = subject;
		this.body = body.toString();
		this.author = author;
	}
}