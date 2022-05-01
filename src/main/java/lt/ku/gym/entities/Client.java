package lt.ku.gym.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="clients")
public class Client implements UserDetails{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 30)
	@Length(min = 3, max = 30, message ="Prisijungimo vardas turi būti ilgesnis nei 3 simboliai ir trumpesnis už 30 simbolių")
	private String username;
	
	@Column(nullable = false)
	@NotEmpty(message = "Įveskite slaptažodį")
	private String password;
	
	@Column(nullable = false, length = 20)
	@Length(min = 3, max = 20, message = "Vardas turi buti ilgesnis nei 3 simboliai ir trumpesnis už 20 simbolius")
	private String name;
	
	@Column(nullable = false, length = 25)
	@Length(min=3, max=25, message = "Pavardė turi buti ilgesnis nei 3 simboliai ir trumpesnis už 25 simbolius")
	private String surname;
	
	@Column(nullable = false)
	@Email(message="Netinkamas El. paštas", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message="Įveskite El. paštą")
	private String email;
	
	@Column
	@Length(max = 15, message = "Telefono numeris negali būti ilgesnis nei 15 simboliai")
	private String phone;
	 
	@Column(nullable = false)
	@NotEmpty
	private String type="user";
	
	@OneToMany(mappedBy="client", fetch = FetchType.EAGER)
	private List<Registration> registrations;
	
	public Client() {}
	
	public Client(
			@Length(min = 3, max = 30, message = "Prisijungimo vardas turi būti ilgesnis nei 3 simboliai ir trumpesnis už 30 simbolių") String username,
			@NotEmpty(message = "Įveskite slaptažodį") String password,
			@Length(min = 3, max = 20, message = "Vardas turi buti ilgesnis nei 3 simboliai ir trumpesnis už 20 simbolius") String name,
			@Length(min = 3, max = 25, message = "Pavardė turi buti ilgesnis nei 3 simboliai ir trumpesnis už 25 simbolius") String surname,
			@Email(message = "Netinkamas El. paštas", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])") @NotEmpty(message = "Įveskite El. paštą") String email,
			@Length(max = 9, message = "Telefono numeris negali būti ilgesnis nei 9 simboliai") String phone,
			@NotEmpty String type, List<Registration> registrations) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.type = type;
		this.registrations = registrations;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Registration> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		HashSet <GrantedAuthority> auth = new HashSet<>();
		auth.add(new SimpleGrantedAuthority(this.type));
		// TODO Auto-generated method stub
		return auth;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
