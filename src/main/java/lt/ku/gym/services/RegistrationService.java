package lt.ku.gym.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ku.gym.entities.Registration;
import lt.ku.gym.repositories.RegistrationRepository;


@Service
public class RegistrationService {
	@Autowired
	RegistrationRepository registrationRepository;
	
	public List<Registration> getRegistrations(){
		return registrationRepository.findAll();
	}
	
	public Registration getRegistration(Integer id) {
		return registrationRepository.getById(id);
	}
	
	public Registration addRegistration(Registration registration) {
		return registrationRepository.save(registration);
	}
	
	public void deleteRegistration(Integer id) {
		registrationRepository.deleteById(id);
	}
	
	public Registration updateRegistration(Registration registration) {
		Registration old = this.getRegistration(registration.getId());
		old.setClient(registration.getClient());
		old.setRegistration_date(registration.getRegistration_date());
		old.setWorkout(registration.getWorkout());
		
		return registrationRepository.save(old);
	}
}
