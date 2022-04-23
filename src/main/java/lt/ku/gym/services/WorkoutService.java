package lt.ku.gym.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ku.gym.entities.Workout;
import lt.ku.gym.repositories.WorkoutRepository;

@Service
public class WorkoutService {
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	public List<Workout> getWorkouts(){
		return workoutRepository.findAll();
		
	}
	
	public Workout addWorkout(Workout workout) {
		return workoutRepository.save(workout);
	}
	
	public Workout updateWorkout(Workout workout) {
		Workout old = workoutRepository.getById(workout.getId());
		old.setName(workout.getName());
		old.setLocation(workout.getLocation());
		old.setPlaces(workout.getPlaces());
		old.setDate( workout.getDate());
		
		workoutRepository.save(old);
		
		return old;
	}
	public void deleteWorkout(Integer id) {
		workoutRepository.deleteById(id);
	}
	public Workout getWorkout(Integer id) {
		return workoutRepository.getById(id);
	}
	
	
}
