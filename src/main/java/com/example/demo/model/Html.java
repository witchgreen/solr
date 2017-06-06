package com.example.demo.model;
import org.springframework.data.annotation.Id;

public class Html {

	@Id
	public String author;

	public String subject;
	public String body;

	public Html() {}

	public Html(String subject, String body) {
		this.subject = subject;
		this.body = body;
	}
}