package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.example.demo.driver.SolrDriver;
import com.example.demo.mapper.HtmlMapper;
import com.example.demo.model.Html;

@Controller
public class SolrMainController{
	
    @Autowired
    private HtmlMapper htmlMapper;
	
	@RequestMapping("/")
	public String getIndex(HttpServletRequest request) {
		System.out.println("index!");		
		return "index";
	}
	
	@RequestMapping("/list")
	public String getList(Model model, HttpServletRequest request) {
//		List<Html> list = htmlMapper.selectHtmlList();
//		for (int i =0; i<list.size(); i ++){			
//			System.out.println("list: "+list.get(i).getSubject());
//		}
		return "list";
	}
    
	@RequestMapping("/detail")
	public String getDetail(HttpServletRequest request) throws Exception {
		
//		List<Html> list = htmlMapper.selectHtmlList();
//		for (int i =0; i<list.size(); i ++){			
//			System.out.println("list: "+list.get(i).getSubject());
//		}
		
		return "detail";
	}

	@RequestMapping("/saveDetail")
	public String saveHtml(HttpServletRequest request) throws Exception {
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
	
	@RequestMapping("/search")
	public String searchHtml(HttpServletRequest request) throws Exception {
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