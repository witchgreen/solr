package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.driver.SolrDriver;
import com.example.demo.mapper.HtmlMapper;
import com.example.demo.model.Html;

@Controller
public class SolrMainController{
	
	private static Logger logger = Logger.getLogger(SolrMainController.class);
	
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
	
	@RequestMapping("/solrsearch")
	public String getSolrSearchJsp(HttpServletRequest request) throws Exception {
		return "solrsearch";
	}
	
//	@RequestMapping("/solrSearchBtnClick")
//	public @ResponseBody ModelAndView getSolrSearch(HttpServletRequest request)throws Exception {
//		ModelAndView mav = new ModelAndView();
//		String q = request.getParameter("q");
//		logger.info("q : "+q);
//		
//		if(!"".equals(q)) {
//			SolrQuery query = new SolrQuery();
//			query.setQuery(q);
//			
//			QueryResponse responseSolr = SolrDriver.solr.query(query);
//		    SolrDocumentList results = responseSolr.getResults();
//		    
//		    mav.addObject("q", q);
//		    mav.addObject("listview", results.toArray());
//		    logger.info(results.toArray());
//		    mav.setViewName("solrsearch");
//		}
//		
//		return mav;
//		
//	}
	
}