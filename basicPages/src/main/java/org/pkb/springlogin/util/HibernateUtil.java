package org.pkb.springlogin.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class HibernateUtil {
	private static final Logger logger =
			LoggerFactory.getLogger(HibernateUtil.class);
	private static SessionFactory sessionFactorty=null;
public  static SessionFactory getSessionFactory(){
	if(sessionFactorty==null){
	logger.info("inside hibernate Util");
	Configuration configuration=new Configuration();
	
	configuration.addPackage("org.pkb.springlogin.entity");

	configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	configuration.setProperty("hibernate.connection.username", "root");
	configuration.setProperty("hibernate.connection.password", "root");
	configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localHost:3306/myusers");
	/*SchemaExport schemaExport=new SchemaExport(configuration);
	schemaExport.create(true, true);*/
	StandardServiceRegistryBuilder srb=new StandardServiceRegistryBuilder();
	srb.applySettings(configuration.getProperties());
	ServiceRegistry serviceRegistry=srb.build();
	sessionFactorty=configuration.buildSessionFactory(serviceRegistry);
	
	}
	return sessionFactorty;
	
	
}
public static void shutDown(){
	if(sessionFactorty!=null)
	sessionFactorty.close();
	sessionFactorty=null;
}
}
