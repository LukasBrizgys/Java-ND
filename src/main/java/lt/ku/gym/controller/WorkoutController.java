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

import lt.ku.gym.entities.Workout;
import lt.ku.gym.services.WorkoutService;
@RequestMapping("/workout")

@Controller
public class WorkoutController {
	@Autowired
	WorkoutService workoutService;
	
	@GetMapping("/")
	public String getWorkouts(Model model) {
		
		model.addAttribute("workouts" , workoutService.getWorkouts());
		
		return "workout_list";
	}
	
	@GetMapping("/new")
	public String newWorkout(Model model) {
		model.addAttribute("workout", new Workout());
		
		return "workout_new";
	}
	@PostMapping("/new")
	public String storeWorkout(
			@Valid
			@ModelAttribute Workout W,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "workout_new";
		}
		workoutService.addWorkout(W);
		return "redirect:/workout/";
	}
	
	@GetMapping("/update/{id}")
	public String updatePage(
			@PathVariable("id") Integer id,
			Model model
			) {
		model.addAttribute("workout", workoutService.getWorkout(id));
		
		return "workout_update";
	}
	
	@PostMapping("/update/{id}")
	public String updateWorkout(
			@Valid
			@ModelAttribute Workout w,
			BindingResult result,
			@PathVariable("id") Integer id
			
			) {
		if(result.hasErrors()) {
			return "workout_update";
		}
		workoutService.updateWorkout(w);
		
		return "redirect:/workout/";
	}
	@GetMapping("/delete/{id}")
	public String clientDelete(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("id", id);
		return "workout_delete";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteClient(@PathVariable("id") Integer id) {
		workoutService.deleteWorkout(id);
		return "redirect:/workout/";
	}
	
}
