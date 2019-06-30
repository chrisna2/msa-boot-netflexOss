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
@MapperScan(value="com.multiDb.postgres.repository",sqlSessionFactoryRef="postgresSessionFactory")
@EnableTransactionManagement
public class PostgresConfig {
	
	@Bean(name="postgresDataSource")
	@ConfigurationProperties(prefix = "spring.postgres.datasource")
	public DataSource postgresDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="postgresSessionFactory")
	public SqlSessionFactory postgresSessionFactory(@Qualifier("postgresDataSource") DataSource postgresDataSource,
													ApplicationContext apContext) throws Exception{
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(postgresDataSource);
		sqlSessionFactoryBean.setMapperLocations(apContext.getResources("classpath:mappers/postgres/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="postgresSessionTemplate")
	public SqlSessionTemplate oracleSqlSessionTemplate(SqlSessionFactory factory) throws Exception{
		return new SqlSessionTemplate(factory);
	}
	
}
