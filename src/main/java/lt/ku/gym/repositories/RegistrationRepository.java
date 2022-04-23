package lt.ku.gym.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import lt.ku.gym.entities.Registration;


public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

}
