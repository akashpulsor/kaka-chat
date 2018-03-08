package chat.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
@EnableKafka
public class SenderConfig {
	
	  @Bean
	  public Map<String, Object> producerConfig() {
	    final Map<String, Object> props = new HashMap<>(4);

	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 5000);

	    return props;
	  }

	  @Bean
	  public ProducerFactory<Integer, String> producerFactory() {
	    return new DefaultKafkaProducerFactory<Integer, String>(producerConfig());
	  }

	  @Bean
	  public KafkaTemplate<Integer, String> kafkaTemplate() {
	    return new KafkaTemplate<Integer, String>(producerFactory());
	  }
	  
	  @Bean
		public KafkaSender kafkaSender(){
			return new KafkaSender();
		}
	
/*	@Bean
	public Map<String,Object> config(){
		Map<String,Object> conf = new HashMap<>();
		conf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		conf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
		conf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return conf;
	}
	
	@Bean
	public ProducerFactory<Integer,String> producerFactory(){
		return  new DefaultKafkaProducerFactory<>(config());
	}
	
	@Bean
	public KafkaTemplate<Integer, String> kafkaTemplate() {
		return new KafkaTemplate<Integer, String>(producerFactory());
	}*/
	
	@Bean
	public ObjectMapper ObjectMapper(){
		return new ObjectMapper(); 
	}
}
