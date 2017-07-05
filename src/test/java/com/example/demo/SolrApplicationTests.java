package com.example.demo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

//import org.apache.tomcat.jdbc.pool.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
 
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SolrApplicationTests {
 
    @Test
    public void contextLoads() {
    }
    
//    @Autowired
//    private DataSource ds;
    
//    @Test
//    public void testConn() throws SQLException{
//    	System.out.println("testConn()");
//    	Connection conn = ds.getConnection();
//    	System.out.println("success!");
//    	conn.close();
//    }
    
//    @Autowired
//    private SqlSessionFactory sqlSession;

//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//    	sqlSessionFactoryBean.setDataSource(dataSource);
//    	return sqlSessionFactoryBean.getObject();
//    }
//    
//    @Test
//    public void testSession() {
//    	System.out.println("testSession() success!");
//    }
    
}