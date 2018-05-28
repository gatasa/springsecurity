package es.alfa.centauri.springSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	public static final String REALM_NAME = "memorynotfound.com";

	 @Autowired
	 private UserDetailsService userDetailsService;
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	  auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	 } 

//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/", "/home","/api/user").permitAll()
//								.antMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated()
//								.and()
//								.formLogin().loginPage("/login").permitAll()
//								.and()
//								.logout().permitAll();
//		
//		http.httpBasic().realmName(REALM_NAME).authenticationEntryPoint(new CustomAuthenticationEntryPoint());
//		http.exceptionHandling().accessDeniedPage("/403");
//	}
	// code from https://github.com/spring-projects/spring-data-examples/blob/master/rest/security/src/main/java/example/springdata/rest/security/Application.java

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().and().authorizeRequests().//
		antMatchers(HttpMethod.GET, "/api/user").authenticated().
				antMatchers(HttpMethod.POST, "/api/user").hasRole("ADMIN").//
				antMatchers(HttpMethod.DELETE, "/api/user/**").hasRole("ADMIN").//
				antMatchers(HttpMethod.PATCH, "/api/user/**").hasRole("ADMIN").and().//
				csrf().disable();
	}
	
//	@Bean(name="passwordEncoder")
//    public PasswordEncoder passwordencoder(){
//     return new BCryptPasswordEncoder();
//    }
	//https://www.harinathk.com/spring/no-passwordencoder-mapped-id-null/
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordencoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}