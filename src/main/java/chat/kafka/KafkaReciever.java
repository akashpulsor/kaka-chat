package chat.kafka;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;;

public class KafkaReciever {
	

	@Autowired
	private MessageDao msgDao;
	
	@Autowired
	private ObjectMapper objectMapper;


	@KafkaListener(id="test",topics="user")
	public void listen( String output ) throws JsonParseException, JsonMappingException, IOException{
		Message msg = objectMapper.readValue(output, Message.class);
		msgDao.save(msg);
	}
}

