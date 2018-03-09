package chat.kafka;

import org.springframework.data.repository.Repository;





public interface UserDao extends  Repository<User, Long>{
	@SuppressWarnings("unchecked")
	User  save(User user);

}
