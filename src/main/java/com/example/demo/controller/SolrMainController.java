package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.driver.SolrDriver;
import com.example.demo.model.Html;
//import com.example.demo.repository.HtmlRepository;//mongo disabled

@RestController
public class SolrMainController{
//	@Autowired
//	private HtmlRepository repository; //mongo disabled
	
	@RequestMapping("/saveHtml")
	public String findTest(HttpServletRequest request) throws Exception {
//		repository.save(new Html(request.getParameter("subject"), request.getParameter("body")));
		
		
		Random random = new Random();
		int nextInt = random.nextInt();
		System.out.println("nextInt: "+nextInt);
//		repository.save(new Html("subject test "+nextInt,"body test "+nextInt));
//		System.out.println(repository.findBySubject("subject test "+nextInt).subject);
		
//		if (repository.findBySubject("subject test "+nextInt) != null){
			
			SolrInputDocument solrDoc = new SolrInputDocument();
            solrDoc.addField("subject", "subject test "+nextInt);
            solrDoc.addField("body", "body test "+nextInt);

            Collection<SolrInputDocument> solrDocs = new ArrayList<SolrInputDocument>();
            solrDocs.add(solrDoc);

            try {
				SolrDriver.solr.add(solrDocs);
				SolrDriver.solr.commit();
			} catch (SolrServerException e) {
				e.printStackTrace();
				return "fail";
			} catch (IOException e) {
				e.printStackTrace();
				return "fail";
			}
            return "success";
//		}else{
//			return "fail";
//		}
	}
}