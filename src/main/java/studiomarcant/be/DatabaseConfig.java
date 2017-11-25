package studiomarcant.be;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataSource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mchange.v2.c3p0.DriverManagerDataSource;

public class DatabaseConfig {
	
	@Autowired
  	private Environment env;

  	@Autowired
  	private DataSource dataSource;

  	@Autowired
  	private LocalContainerEntityManagerFactoryBean entityManagerFactory;

	/**
	   * DataSource definition for database connection. Settings are read from
	   * the application.properties file (using the env object).
	   */
	  @Bean
	  public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClass(env.getProperty("jdbc.driverClassName"));
	    dataSource.setJdbcUrl(env.getProperty( "spring.datasource.url"));
	    dataSource.setUser(env.getProperty("spring.datasource.username"));
	    dataSource.setPassword(env.getProperty("spring.datasource.password"));
	    return dataSource;
	  }

	  /**
	   * Declare the JPA entity manager factory.
	   */
	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean entityManagerFactory =
	        new LocalContainerEntityManagerFactoryBean();
	    
	    entityManagerFactory.setDataSource((javax.sql.DataSource) dataSource);
	    
	    // Classpath scanning of @Component, @Service, etc annotated class
	    entityManagerFactory.setPackagesToScan(
	        env.getProperty("entitymanager.packagesToScan"));
	    
	    // Vendor adapter
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
	    
	    // Hibernate properties
	    Properties additionalProperties = new Properties();
	    additionalProperties.put(
	        "hibernate.dialect", 
	        env.getProperty("spring.jpa.properties.hibernate.dialect"));
	    additionalProperties.put(
	        "hibernate.show_sql", 
	        env.getProperty("spring.jpa.show-sql"));
	    additionalProperties.put(
	        "hibernate.hbm2ddl.auto", 
	        env.getProperty("spring.jpa.hibernate.ddl-auto"));
	    entityManagerFactory.setJpaProperties(additionalProperties);
	    
	    return entityManagerFactory;
	  }

	  /**
	   * Declare the transaction manager.
	   */
	  @Bean
	  public JpaTransactionManager transactionManager() {
	    JpaTransactionManager transactionManager = 
	        new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(
	        entityManagerFactory.getObject());
	    return transactionManager;
	  }
	  
	  /**
	   * PersistenceExceptionTranslationPostProcessor is a bean post processor
	   * which adds an advisor to any bean annotated with Repository so that any
	   * platform-specific exceptions are caught and then rethrown as one
	   * Spring's unchecked data access exceptions (i.e. a subclass of 
	   * DataAccessException).
	   */
	  @Bean
	  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	    return new PersistenceExceptionTranslationPostProcessor();
	  }

	
	  
	  public SessionFactory getSessionfactory() {
		  // Create configuration instance
		  	Configuration config = new Configuration();
		  // Create properties file
		  	Properties properties = new Properties();
		  	try {
				properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		  // Pass hibernate configuration file
		  	config.setProperties(properties);
		  // Since version 4.x, service registry is being used
		  	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
		  	applySettings(config.getProperties()).build(); 
		  //Create Session factory instance
		  	SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		  return factory;
	  }	
		 	
	  
	  // Private fields
	  
	  		@Bean
			public SessionFactory sessionFactory(){
	  		SessionFactory sessionFactoryInstance=getSessionfactory();
		  	return sessionFactoryInstance;
			}
	  		
	  		private Session session;
	  		
		  	public Session getSession(){
	  		session=sessionFactory().getCurrentSession();
	  		return session;
	  		}
	  		
	  		public void beginTransaction(){
	  			
	  			session.getTransaction().begin();
	  			// Print out all required information
	  			System.out.println("Session Is Opened :: "+session.isOpen());
	  			System.out.println("Session Is Connected :: "+session.isConnected()); 

	  			// Commit transaction
	  			 session.getTransaction().commit();

	  			 System.exit(0);	
	  			
	  		}
		  }	
	
	

