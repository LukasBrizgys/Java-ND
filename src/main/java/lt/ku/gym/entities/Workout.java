package lt.ku.gym.entities;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="workouts")
public class Workout {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	@Length(min=3, message="Treniruotės pavadinimas turi būti ilgesnis nei 3 simboliai")
	private String name;
	
	@Column
	@NotEmpty(message = "Įveskite datą")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;
	
	@Column
	@Min(value=0, message = "Vietų skaičius turi būti didesnis arba lygus 0")
	@Max(value=9999, message = "Vietų skaičius turi būti mažesnis arba lygus 9999")
	@NotNull(message = "Įveskite vietų skaičių")
	private Integer places;
	
	@Column(nullable = false)
	@NotEmpty(message = "Įrašykite treniruotės vietą")
	private String location;
	
	@Column
	private String fileName;
	
	@OneToMany(mappedBy = "workout", fetch = FetchType.EAGER)
	private List<Registration> registrations;
	
	public Workout() {}
	
	public Workout(@Length(min = 3, message = "Treniruotės pavadinimas turi būti ilgesnis nei 3 simboliai") String name,
			@NotEmpty(message = "Įveskite datą") String date,
			@Min(value = 0, message = "Vietų skaičius turi būti didesnis arba lygus 0") @Max(value = 9999, message = "Vietų skaičius turi būti mažesnis arba lygus 9999") @NotNull(message = "Įveskite vietų skaičių") Integer places,
			@NotEmpty(message = "Įrašykite treniruotės vietą") String location, String fileName) {
		super();
		this.name = name;
		this.date = date;
		this.places = places;
		this.location = location;
		this.fileName = fileName;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	
	public void setDate(String date) {
		this.date = date;
	}

	public Integer getPlaces() {
		return places;
	}

	public void setPlaces(Integer places) {
		this.places = places;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public List<Registration> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

}
