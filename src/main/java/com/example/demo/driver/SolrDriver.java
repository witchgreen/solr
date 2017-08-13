package com.example.demo.driver;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class SolrDriver {
	public static String url = "http://13.124.168.194:8983/solr/solr_test";
    public static SolrClient solr = new HttpSolrClient(url); 
}
