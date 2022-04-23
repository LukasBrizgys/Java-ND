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
		model.addAttribute("client", new Client());
		return "client_new";
	}
	
	
	@PostMapping("/new")
	public String addClient(Model model,
			@Valid
			@ModelAttribute Client c,
			BindingResult result) {
		if(result.hasErrors()) {
			return "client_new";
		}
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
			@Valid
			@ModelAttribute Client c,
			BindingResult result,
			@PathVariable("id") Integer id,
			Model model
			) {
		if(result.hasErrors()) {
			return "client_update";
		}
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
