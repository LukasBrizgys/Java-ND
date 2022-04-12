package lt.ku.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.ku.gym.services.ClientService;
import lt.ku.gym.entities.Client;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	ClientService clientService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("clients", clientService.getClients());
		return "client_list";
	}
	@GetMapping("/new")
	public String clientNew(Model model) {
		return "client_new";
	}
	@PostMapping("/new")
	public String addClient(Model model,
			@RequestParam("name") String name,
			@RequestParam("surname") String surname,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone) {
		Client c = new Client(name,surname,email,phone);
		clientService.addClient(c);
		return "redirect:/client/";
	}
	@GetMapping("/update/{id}")
	public String clientUpdate(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("client", clientService.getClient(id));
		return "client_update";
	}
	
	@PostMapping("/update/{id}")
	public String updateClient(
			@PathVariable("id") Integer id,
			@ModelAttribute Client c
			) {
		clientService.updateClient(c);
		return "redirect:/client/";
	}
	@GetMapping("/delete/{id}")
	public String clientDelete(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("id", id);
		return "client_delete";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteClient(@PathVariable("id") Integer id) {
		clientService.deleteClient(id);
		return "redirect:/client/";
	}
}
