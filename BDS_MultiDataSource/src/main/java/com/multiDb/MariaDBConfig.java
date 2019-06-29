package com.multiDb;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value = "com.multiDb.maria.repository", sqlSessionFactoryRef = "mariaSqlSessionFactory")
@EnableTransactionManagement
public class MariaDBConfig {
	
	
	@Bean(name="mariaDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.maria.datasource")
	public DataSource mariaDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="mariaSqlSessionFactory")
	@Primary
	public SqlSessionFactory mariaSqlSessionFactory(@Qualifier("mariaDataSource") DataSource mariaDataSource,
													ApplicationContext apContext) throws Exception{
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(mariaDataSource);
		sqlSessionFactoryBean.setMapperLocations(apContext.getResources("classpath:mappers/maria/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
		
	}
	
	@Bean(name="mariaSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate mariaSqlSessionTemplate(SqlSessionFactory factory) throws Exception{
		return new SqlSessionTemplate(factory);
	}
	
	
	
}
