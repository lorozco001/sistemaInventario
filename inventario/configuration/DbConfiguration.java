package dgac.inventario.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DbConfiguration {

	@Bean(name = "sessionInventario")
	@Primary
	@Qualifier("Inventario")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("dgac.inventario.entidades");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}
	
	@Bean(name = "sessionDgac")
	public LocalSessionFactoryBean sessionFactoryDgacDb() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource2());
		sessionFactoryBean.setPackagesToScan("dgac.inventario.entidades");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}

	
	@Bean(name="dataSourceInventario")
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:14792/inventario?useSSL=false");
		datasource.setUsername("root");
		datasource.setPassword("pase14792");		
		return datasource;
	}
	
	@Bean(name="dataSourceDgac")
	public DataSource dataSource2() {
		DriverManagerDataSource datasource2 = new DriverManagerDataSource();
		datasource2.setDriverClassName("com.mysql.jdbc.Driver");
		datasource2.setUrl("jdbc:mysql://localhost:14792/dgac?useSSL=false");
		datasource2.setUsername("root");
		datasource2.setPassword("pase14792");		
		return datasource2;
	}
	
	
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("show_sql", "true");
		
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		hibernateTransactionManager.setSessionFactory(sessionFactoryDgacDb().getObject());
		return hibernateTransactionManager;
	}
	


}
