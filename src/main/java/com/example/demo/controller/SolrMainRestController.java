package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.driver.SolrDriver;

@Controller
public class SolrMainRestController {
	private static Logger logger = Logger.getLogger(SolrMainController.class);
	
	@RequestMapping("/solrSearchBtnClick")
	public @ResponseBody Map<String, Object> getSolrSearch(HttpServletRequest request)throws Exception {
		//ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String q = request.getParameter("q");
		logger.info("q : "+q);
		
		if(!"".equals(q)) {
			SolrQuery query = new SolrQuery();
			query.setQuery(q);
			query.setRows(Integer.MAX_VALUE);
			QueryResponse responseSolr = SolrDriver.solr.query(query);
		    SolrDocumentList results = responseSolr.getResults();
		    
		    map.put("listview",results);
		    
		    logger.info(map.get("listview").toString());
		    
		}
		
		return map;
		
	}
}
