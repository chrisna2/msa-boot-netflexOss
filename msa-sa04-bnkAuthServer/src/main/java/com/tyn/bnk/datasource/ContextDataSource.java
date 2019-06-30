package com.tyn.bnk.datasource;

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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value = "com.tyn.bnk.repository", sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
public class ContextDataSource {

	@Primary
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource oAuthDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource,
											   ApplicationContext apContext) throws Exception{
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(apContext.getResources("classpath:mappers/**/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
		
	}
	
	@Primary
	@Bean(name="sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) throws Exception{
		return new SqlSessionTemplate(factory);
	}
	
	@Primary
	@Bean(name="sqlTransactionManager")
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
}
