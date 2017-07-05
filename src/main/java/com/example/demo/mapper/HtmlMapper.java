package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.Html;

public interface HtmlMapper {
	//글작성
    public void insertHtml(Html html)throws Exception;
    
    //글목록
    public List<Html>selectHtmlList()throws Exception; 

}
