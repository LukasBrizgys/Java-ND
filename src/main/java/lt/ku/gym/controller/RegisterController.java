package lt.ku.gym.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.ku.gym.entities.Client;
import lt.ku.gym.services.ClientService;

@Controller
public class RegisterController {

	@Autowired
	ClientService clientService;
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("client", new Client());
		return "register";
	}
	
	
	
	@PostMapping("/register")
	public String newClient(
			Model model,
			@Valid
			@ModelAttribute Client c,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "register";
		}
		clientService.addClient(c);
		return "register_success";
	}
	
	
}
