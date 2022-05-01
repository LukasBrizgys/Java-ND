package lt.ku.gym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import lt.ku.gym.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	Client findByUsername(String username);
}
