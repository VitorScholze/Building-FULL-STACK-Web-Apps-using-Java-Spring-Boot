package net.javaguides.todo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Bean
    public static PasswordEncoder passworldEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> {
            // authorize.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
            // authorize.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN");
            // authorize.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN");
            // authorize.requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "USER");
            // authorize.requestMatchers(HttpMethod.PATCH, "/api/**").hasAnyRole("ADMIN", "USER");
            authorize.anyRequest().authenticated();
        })
        .httpBasic(Customizer.withDefaults()); 

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails vitor = User.builder()
                .username("vitor")
                .password(passworldEncoder().encode("password"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                    .username("admin")
                    .password(passworldEncoder().encode("admin"))
                    .roles("ADMIN")
                    .build();

        return new InMemoryUserDetailsManager(vitor, admin);
    }
}
