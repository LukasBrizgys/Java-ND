package lt.ku.pvmskaiciuokle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController{

	@GetMapping("/")
	public String home() {
		return "home";
	}
	@PostMapping("/rezultatai")
	public String result(
			 @RequestParam(value = "kaina", required = false, defaultValue = "-1") Double kaina,
			 @RequestParam(value ="kiekis", required = false, defaultValue = "0") Integer kiekis,
			 Model model
			) {
		String[] errors;
		boolean isErrors = false;
		errors = new String[2];
		if(kaina < 0 || kaina == null) {
			errors[0] = "Blogai įvesta kaina";
			isErrors = true;
		}
		if(kiekis < 1 || kiekis == null) {
			errors[1] = "Blogas kiekis";
			isErrors = true;
		}
		if(isErrors == true) {
			model.addAttribute("isErrors", isErrors);
			model.addAttribute("errors", errors);
			return "rezultatai";
		}
			
		Double VntKainaBePVM = kaina / 1.21;
		Double PVMVieneto = kaina * 21 / 121;
		Double VntKainaSuPVM = kaina;
		Double BendraKainaBePVM = VntKainaBePVM * kiekis;
		Double BendraKainaSuPVM = kaina * kiekis;
		Double BendrasPVM = PVMVieneto * kiekis;
		model.addAttribute("VntKainaBePVM" , String.format("%.2f",VntKainaBePVM));
		model.addAttribute("PVMVieneto" , String.format("%.2f",PVMVieneto));
		model.addAttribute("VntKainaSuPVM" , String.format("%.2f",VntKainaSuPVM));
		model.addAttribute("BendraKainaBePVM" , String.format("%.2f",BendraKainaBePVM));
		model.addAttribute("BendraKainaSuPVM" , String.format("%.2f",BendraKainaSuPVM));
		model.addAttribute("BendrasPVM" , String.format("%.2f",BendrasPVM));
		model.addAttribute("kiekis", kiekis);
		
		return "rezultatai";
	}
	
}