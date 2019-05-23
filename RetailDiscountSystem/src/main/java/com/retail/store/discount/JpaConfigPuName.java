package com.retail.store.discount;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class JpaConfigPuName
{

	@Bean(name = "DataSource")
	public DataSource getDataSource()
	{
		return DataSourceBuilder.create().url("jdbc:h2:mem:retail_discount_server_db").username("discountuser")
				.password("discount").build();
	}

	@Bean(name = "JpaVendorAdapter")
	public JpaVendorAdapter getJpaVendorAdapter()
	{
		HibernateJpaVendorAdapter j = new HibernateJpaVendorAdapter();
		j.setShowSql(true);
		j.setDatabase(Database.H2);
		;
		return j;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean()
	{

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setJpaVendorAdapter(getJpaVendorAdapter());
		emf.setPersistenceUnitName("RETAIL_DISCOUNT_SERVER_PU");
		emf.setPackagesToScan("com.retail.store.discount.model");
		Properties prop = new Properties();

		prop.setProperty("hibernate.jdbc.lob.non_contextual_creation", "true");

		emf.setJpaProperties(prop);

		return emf;

	}

}
