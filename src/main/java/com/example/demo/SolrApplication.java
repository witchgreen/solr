package com.example.demo;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@MapperScan(value = {"com.example.demo.mapper"})
public class SolrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolrApplication.class, args);
	}

    @Autowired
    private DataSource dataSource;
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml");
		sessionFactory.setDataSource(dataSource);       
		sessionFactory.setMapperLocations(res);            
		return sessionFactory.getObject();
	}
}
