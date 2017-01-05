package org.pkb.springlogin.config;
 
import org.pkb.springlogin.authentication.MyDBAuthenticationService;
import org.pkb.springlogin.controller.MainController;
import org.pkb.springlogin.dao.CompanyInfoDao;
import org.pkb.springlogin.manager.EmailHandler;
import org.pkb.springlogin.model.CompanyRegVO;
import org.pkb.springlogin.smtp.SendMail;
import org.pkb.springlogin.util.HibernateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Configuration
@ComponentScan(basePackageClasses={EmailHandler.class,CompanyRegVO.class,CompanyInfoDao.class,MainController.class,MyDBAuthenticationService.class,CompanyRegVO.class,ApplicationContextConfig.class,HibernateUtil.class,SendMail.class})
public class ApplicationContextConfig {
	@Bean
  public ResourceBundleMessageSource messageSource() {
      ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
      // Load property in message/validator.properties
      rb.setBasenames(new String[] { "messages/validator" });
      return rb;
  }
 
  @Bean(name = "viewResolver")
  public InternalResourceViewResolver getViewResolver() {
      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
      viewResolver.setPrefix("/WEB-INF/pages/");
      viewResolver.setSuffix(".jsp");
      return viewResolver;
  }
 

 
}