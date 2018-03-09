package chat.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/kafka")
public class SenderController {
	
	@Autowired
	private KafkaSender kafkaSender;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MessageDao msgDao;


	@RequestMapping(value = "/producer/{topic}", method = RequestMethod.GET)
	public String producer(@RequestParam("message") String msg,
			@RequestParam("senderid") String senderId,
			@RequestParam("recieverid") String recieverId,
			@PathVariable String topic) throws JsonProcessingException {
		Message messsage = new Message();
		messsage.setMsg(msg);
		messsage.setSenderid(senderId);
		messsage.setReceiverid(recieverId);
		messsage.setTime(Utils.getEpochMillis());
		
		kafkaSender.send(topic,objectMapper.writeValueAsString(messsage));

		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}
	
	@RequestMapping(value = "/producer/{topic}", method = RequestMethod.GET,produces = "application/json")
	public List<Message> producer(
			@RequestParam("senderid") String senderId,
			@RequestParam("recieverid") String recieverId,
			@PathVariable String topic) throws JsonProcessingException {

		List<Message> messages = msgDao.findMessageBySenderidAndReceiverid(senderId, recieverId);

		return null;
	}

	

}
