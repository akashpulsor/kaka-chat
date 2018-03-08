package chat.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class KafkaSender {
	
	@Autowired
	public KafkaTemplate<Integer, String> kafkaTemplate;
	
	public void send( String topic,String message){
		
		Message<String> msg = MessageBuilder.withPayload(message)
				.setHeader(KafkaHeaders.TOPIC, topic)
				.build();
		ListenableFuture<SendResult<Integer,String>> lstful = kafkaTemplate.send(msg);
		lstful.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>(){

			@Override
			public void onSuccess(SendResult<Integer, String> arg0) {
				// Logger here
				
			}

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Logger here
				
			}
			
		});
	}
}
