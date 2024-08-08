package com.example.bookTest.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

	@Bean // 필요한 객체(new DriverManagerDataSource())에 넣어주기 위해 스프링이 Bean에 자동으로 넣어준다. 
	public DataSource dataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("seo");
		ds.setPassword("1234");
		ds.setUrl("jdbc:mysql://localhost:3306/seo");
		
		return ds;
	}
	
	@Bean // 필요한 객체(new JdbcTemplate(dataSource))에 넣어주기 위해 스프링이 Bean에 자동으로 넣어준다. 
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		
		return new JdbcTemplate(dataSource);
	}
}
