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
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value = "com.multiDb.oracle.repository", sqlSessionFactoryRef = "oracleSqlSessionFactory")
@EnableTransactionManagement
public class OracleDBConfig {
	
	@Bean(name="oracleDataSource")
	@ConfigurationProperties(prefix = "spring.oracle.datasource")
	public DataSource oracleDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="oracleSqlSessionFactory")
	public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource oracleDataSource,
													ApplicationContext apContext) throws Exception{
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(oracleDataSource);
		sqlSessionFactoryBean.setMapperLocations(apContext.getResources("classpath:mappers/oracle/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="oracleSqlSessionTemplate")
	public SqlSessionTemplate oracleSqlSessionTemplate(SqlSessionFactory factory) throws Exception{
		return new SqlSessionTemplate(factory);
	}
	
}
