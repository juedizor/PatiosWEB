package co.com.app.otraentidad.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = {
		"co.com.app.otraentidad.repository" }, entityManagerFactoryRef = "pruebaEntityManager", transactionManagerRef = "pruebaTransactionManager")
public class PruebaConfigBD {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean pruebaEntityManager() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(pruebaDataSource());
		em.setPackagesToScan(new String[] { "co.com.app.otraentidad.domain" });
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean
	public DataSource pruebaDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name1"));
		dataSource.setUrl(env.getProperty("spring.datasource.url1"));
		dataSource.setUsername(env.getProperty("spring.datasource.username1"));
		dataSource.setPassword(env.getProperty("spring.datasource.password1"));

		return dataSource;
	}

	@Bean
	PlatformTransactionManager pruebaTransactionManager() {
		return new JpaTransactionManager(pruebaEntityManager().getObject());
	}

}
