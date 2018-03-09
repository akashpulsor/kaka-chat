package chat.kafka;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;




public interface MessageDao extends CrudRepository<Message, Long>{

	
	Message save(Message msg);

	List<Message> findMessageBySenderidAndReceiverid(String sender,String reciever);
}
