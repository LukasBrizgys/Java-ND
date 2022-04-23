package lt.ku.gym.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.ku.gym.entities.Registration;
import lt.ku.gym.services.ClientService;
import lt.ku.gym.services.RegistrationService;
import lt.ku.gym.services.WorkoutService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	WorkoutService workoutService;
	
	@GetMapping("/")
	public String registrationList(Model model) {
		model.addAttribute("registrations", registrationService.getRegistrations());
		
		return "registration_list";
	}
	
	@GetMapping("/new")
	public String newPage(Model model) {
		model.addAttribute("registration", new Registration());
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("workouts", workoutService.getWorkouts());
		return "registration_new";
	}
	
	@PostMapping("/new")
	public String storeRegistration(
			@Valid
			@ModelAttribute Registration registration,
			BindingResult result,
			@RequestParam("client_select") Integer clientID,
			@RequestParam("workout_select") Integer workoutID,
			Model model
			) {
				
		if(result.hasErrors()) {
			model.addAttribute("clients", clientService.getClients());
			model.addAttribute("workouts", workoutService.getWorkouts());
			return "registration_new";
		}
		
		registration.setClient(clientService.getClient(clientID));
		registration.setWorkout(workoutService.getWorkout(workoutID));
		registrationService.addRegistration(registration);
		
		
		return "redirect:/registration/";
	}
	
	@GetMapping("/update/{id}")
	public String updatePage(
			@PathVariable("id") Integer id,
			Model model
			) {
		model.addAttribute("registration", registrationService.getRegistration(id));
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("workouts", workoutService.getWorkouts());
		return "registration_update";
		
	}
	
	@PostMapping("/update/{id}")
	public String updateRegistration(
			@Valid
			@ModelAttribute Registration R,
			BindingResult result,
			@PathVariable("id") Integer id,
			Model model
			
			) {
		
		if(result.hasErrors()) {
			model.addAttribute("clients", clientService.getClients());
			model.addAttribute("workouts", workoutService.getWorkouts());
			return "registration_update";
		}
		registrationService.updateRegistration(R);
		return "redirect:/registration/";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePage(Model model, @PathVariable("id") Integer id) {
		
		model.addAttribute("id", id);
		return "registration_delete";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteRegistration(@PathVariable("id") Integer id) {
		registrationService.deleteRegistration(id);
		
		return "redirect:/registration/";
	}
}
