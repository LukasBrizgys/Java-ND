package lt.ku.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lt.ku.gym.entities.Client;
import lt.ku.gym.services.ClientService;

@Controller
public class HomeController {
	@Autowired
	ClientService clientService;
	@GetMapping("/")
	public String home() {
		/*
		Client c = new Client("admin", "admin", "admin","admin", "admin@gmail.com", "+370655532","admin");
		clientService.addClient(c); //admin sukurimas
		*/
		return "home";
	}
}
