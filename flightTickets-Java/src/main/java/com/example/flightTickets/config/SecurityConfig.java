//package com.example.flightTickets.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//		UserDetails user = User.withUsername("user").password(passwordEncoder.encode("user")).roles("USER").build();
//
//		UserDetails admin = User.withUsername("lucag").password(passwordEncoder.encode("Ciuc6973")).roles("USER", "ADMIN")
//				.build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
//
//	@SuppressWarnings({ "deprecation", "removal" })
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//		return http.build();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		return encoder;
//	}
//}
