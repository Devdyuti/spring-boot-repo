package org.tutorial.jpa.tuto.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class TutorialConfig {
		
	@Value("${myprops.datasource.url}")
	private  String PROPERTY_URL;
	@Value("${myprops.datasource.username}")
	private  String PROPERTY_USERNAME;
	@Value("${myprops.datasource.password}")
	private  String PROPERTY_PASSWORD;
	@Value("${myprops.datasource.driver-class-name}")
	private  String PROPERTY_DRIVER;
	@Value("${myprops.jpa.properties.hibernate.dialect}")
	private  String PROPERTY_DIALECT;
	@Value("${myprops.jpa.show-sql}")
	private  String PROPERTY_SHOW_SQL;
	@Value("${myprops.jpa.hibernate.ddl-auto}")
	private  String PROPERTY_HBM2DDL;
	

	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {		
		LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
		lfb.setPackagesToScan("org.tutorial.jpa.tuto.entity");
		lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		lfb.setDataSource(dataSource());
		lfb.setPersistenceUnitName("userx");
		lfb.setJpaVendorAdapter(jpaVendorAdapter());
		lfb.setJpaProperties(jpaProperties());
		return lfb;
		
	}
	
	@Bean
	DataSource dataSource() {
		
		DataSourceBuilder ds=DataSourceBuilder.create();
		ds.url(PROPERTY_URL);
		ds.username(PROPERTY_USERNAME);
		ds.password(PROPERTY_PASSWORD);
		ds.driverClassName(PROPERTY_DRIVER);
		
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setUrl(PROPERTY_URL));
//		ds.setUsername(PROPERTY_USERNAME));
//		ds.setPassword(PROPERTY_PASSWORD));
//		ds.setDriverClassName(PROPERTY_DRIVER));
		return ds.build();
	}
	
	@Bean
	Properties jpaProperties() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_DIALECT, PROPERTY_DIALECT);
		properties.setProperty(PROPERTY_SHOW_SQL, PROPERTY_SHOW_SQL);
		properties.setProperty(PROPERTY_HBM2DDL, PROPERTY_HBM2DDL);
		return properties;
	}
	
	@Bean
	JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	JpaVendorAdapter  jpaVendorAdapter(){
		HibernateJpaVendorAdapter jva=new HibernateJpaVendorAdapter();
		jva.setGenerateDdl(true);
		jva.setShowSql(true);
		return jva;
	}
}
