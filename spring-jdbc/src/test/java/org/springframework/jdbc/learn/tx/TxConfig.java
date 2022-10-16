package org.springframework.jdbc.learn.tx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author Jing Tao
 * @date 2022/9/14 18:17
 */
@Configuration // 表明该类是Spring配置类，需要扫描该类的配置信息
@EnableTransactionManagement // 激活基于注解的声明式事务
public class TxConfig {

	/**
	 * 定义数据源bean
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("123456aa");
		return dataSource;
	}

	/**
	 * 定义事务管理bean
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());// 注入dataSource
		return transactionManager;
	}

	/**
	 * 定义TransactionTemplate类型的bean
	 */
	@Bean
	public TransactionTemplate transactionTemplate() {
		TransactionTemplate transactionTemplate = new TransactionTemplate();
		transactionTemplate.setTransactionManager(transactionManager());// 注入事务管理器
		return transactionTemplate;
	}

	/**
	 * 配置namedParameterJdbcTemplate组件
	 */
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource());// 注入dataSource
		return template;
	}

	/**
	 * 为BlogDao注册bean
	 */
	@Bean
	public PersonDao personDao() {
		PersonDao blogDao = new PersonDao();
		blogDao.setNamedTemplate(namedParameterJdbcTemplate());// 注入namedParameterJdbcTemplate
		return blogDao;
	}

	/**
	 * 为BlogService注册bean
	 */
	@Bean
	public PersonService personService() {
		PersonService blogService = new PersonService();
		blogService.setBlogDao(personDao());// 注入blogDao
		return blogService;
	}
}
