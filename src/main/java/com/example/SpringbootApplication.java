package com.example;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.MenuService;

@Controller
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@MapperScan("com.example.dao")
public class SpringbootApplication {
	
	@Autowired
	private MenuService menuService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	/**
	 * DataSource配置
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource(){
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}

	/**
	 * 提供SqlSession
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@RequestMapping("/")
	public String index(ModelMap map){
		return "user/login";
	}
}
