package in.masterpapa.krishi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class DataSourceConfig {

	@Bean
	@Qualifier("customDataSource")
	public DataSource customDataSource() {
		DataSourceBuilder<?> builder = DataSourceBuilder.create();
		builder.url("jdbc:mysql://localhost:3306/krishi");
		builder.driverClassName("com.mysql.cj.jdbc.Driver");
		builder.username("root");
		builder.password("root");
		return (DataSource) builder.build();
	}

}
