package chat.kafka;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaReciever {

	@KafkaListener(id="test",topics="user")
	public void listen( String output ){
		System.out.println("data recieved" + output);
	}
}

