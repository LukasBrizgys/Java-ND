package lt.ku.gym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.ku.gym.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{

}