package com.example.demo.driver;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class SolrDriver {
	public static String url = "http://localhost:8983/solr/test";
    public static SolrClient solr = new HttpSolrClient(url); 
}
