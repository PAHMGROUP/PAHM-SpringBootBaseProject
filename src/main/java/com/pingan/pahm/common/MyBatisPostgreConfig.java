package com.pingan.pahm.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author GYB
 */
@Configuration
@MapperScan(basePackages = "com.pingan.pahm.dao.postgre", sqlSessionTemplateRef  = "postgreSqlSessionTemplate")

public class MyBatisPostgreConfig {

    @Bean(name = "postgreDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgre")
    public DataSource customDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "postgreSqlSessionFactory")
    public SqlSessionFactory customSqlSessionFactory(@Qualifier("postgreDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "postgreTransactionManager")
    public DataSourceTransactionManager customTransactionManager(@Qualifier("postgreDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "postgreSqlSessionTemplate")
    public SqlSessionTemplate customSqlSessionTemplate(@Qualifier("postgreSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}