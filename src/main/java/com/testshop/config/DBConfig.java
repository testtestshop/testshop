package com.testshop.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	private String url = "jdbc:mysql://localhost:3306/testshop";
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "";
	private String hibernateDialect = "org.hibernate.dialect.MySQL5Dialect";
	
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        return new HikariDataSource(config);
    }
    
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(
				dataSource());
		builder.scanPackages("com.testshop.domain").addProperties(
				getHibernateProperties());

		return builder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", hibernateDialect);
		prop.put("hibernate.hbm2ddl.auto", "create-drop");
		prop.put("hibernate.hbm2ddl.import_files", "import.sql");
		
		return prop;
	}
	
	@Bean(name = "transactionManager")
	public HibernateTransactionManager txManager() {
		return new HibernateTransactionManager(sessionFactory());
	}
}
