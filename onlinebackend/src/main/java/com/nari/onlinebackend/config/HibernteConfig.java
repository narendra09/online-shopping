package com.nari.onlinebackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.nari.onlinebackend.dto"})
@EnableTransactionManagement
public class HibernteConfig
{
  private static final String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
  private static final String DATABASE_DRIVER="org.h2.Driver";
  private static final String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
  private static final String DATABASE_USERNAME="sa";
  private static final String DATABASE_PASSWORD="";
  
  @Bean
  public DataSource getDataSource()
  {
	  DriverManagerDataSource datasource=new DriverManagerDataSource();
	 datasource.setDriverClassName(DATABASE_DRIVER);
	 datasource.setUrl(DATABASE_URL);
	 datasource.setUsername(DATABASE_USERNAME);
	 datasource.setPassword(DATABASE_PASSWORD);
	  return datasource;
  }
  
  @Bean
  public SessionFactory getSessionFactory(DataSource ds)
  {
	  LocalSessionFactoryBuilder sf=new LocalSessionFactoryBuilder(ds);
	  sf.addProperties(getHibernateProperties());
	  sf.scanPackages("com.nari.onlinebackend.dto");
	  return sf.buildSessionFactory();
  }

private Properties getHibernateProperties() {
	Properties prop=new Properties();
	prop.put("hibernate.dialect", DATABASE_DIALECT);
	prop.put("hibernate.show_sql", "true");
	prop.put("hibernate.hbm2ddl.auto", "update");
	return prop;
}

@Bean
public HibernateTransactionManager getTransactionManager(SessionFactory sf)
{
	HibernateTransactionManager tx=new HibernateTransactionManager(sf);
	return tx;
}
}
