package login.trail.configuration;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

public class Securityconfig {
	  @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		  http
          .authorizeHttpRequests((authz) -> authz
        	 .requestMatchers("/","/shop/**","/register").permitAll() 
              .anyRequest().authenticated()
          );
          
      return http.build();
  }
}
