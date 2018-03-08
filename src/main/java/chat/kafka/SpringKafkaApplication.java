package chat.kafka;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootApplication(scanBasePackages="chat.kafka.config")
public class SpringKafkaApplication {

	

	  public static void main(String[] args) throws JsonProcessingException {
	    SpringApplication.run(SpringKafkaApplication.class, args);
	    	
		
	  }
	  
	  
	  

}
