package lt.ku.gym.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lt.ku.gym.services.ClientService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	ClientService clientService;
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		auth.userDetailsService(this.clientService)
		.passwordEncoder(bc);
		
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/client/").hasAnyRole("admin")
		.antMatchers("/client/new").hasAnyRole("admin")
		.antMatchers("/client/update").hasAnyRole("admin")
		.antMatchers("/client/remove").hasAnyRole("admin")
		.antMatchers("/workout/new").hasAnyRole("admin")
		.antMatchers("/workout/update").hasAnyRole("admin")
		.antMatchers("/workout/remove").hasAnyRole("admin")
		.antMatchers("/").permitAll()
		.antMatchers("/login*").permitAll()
		.antMatchers("/register*").permitAll()
		.anyRequest().authenticated()
		
		.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.failureUrl("/login-error")
		.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/");
	}



	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
