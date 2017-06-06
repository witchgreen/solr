package com.example.demo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Html;

public interface HtmlRepository extends MongoRepository<Html, String>{

	public Html findBySubject(String subject);
	public List<Html> findByBody(String body);

}
