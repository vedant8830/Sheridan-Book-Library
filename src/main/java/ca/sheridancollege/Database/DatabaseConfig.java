package ca.sheridancollege.Database;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
	
	@Bean

	public NamedParameterJdbcTemplate namedParameterJdbcTemplate

	(DataSource dataSource) {

	return new NamedParameterJdbcTemplate(dataSource);

	}
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost/Assignment3");
		datasource.setUsername("root");
		datasource.setPassword("vedant8830");
		
		return datasource;
	}


}
