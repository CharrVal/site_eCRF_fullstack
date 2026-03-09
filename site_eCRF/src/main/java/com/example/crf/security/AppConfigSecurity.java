package com.example.crf.security;

import com.example.crf.security.Jwt.JwtAuthenticationFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AppConfigSecurity {

    protected final Log logger = LogFactory.getLog(getClass());
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    public AppConfigSecurity(JwtAuthenticationFilter jwtAuthenticationFilter, AuthenticationProvider authenticationProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth
                    // accueil (tout le monde y a accès)
                    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    .requestMatchers("/auth/**").permitAll()
                    .requestMatchers("/accueil").permitAll()
                    .requestMatchers("/connexion").permitAll()
                    .requestMatchers("/error").permitAll()

                    // ACCÈS PUBLIC
                    .requestMatchers(HttpMethod.GET, "/studies/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/visits/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/patients/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/vitalSigns/**").permitAll()

                    // ACCÈS ADMIN
                    .requestMatchers(HttpMethod.POST, "/studies/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/visits/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/vitalSigns/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/patients/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/studies/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/visits/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/vitalSigns/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/patients/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/studies/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/visits/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/vitalSigns/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/patients/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/studies/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/visits/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/vitalSigns/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/patients/**").hasRole("ADMIN")

                    .anyRequest().authenticated();
        });

        // Désactivé Cross Site Request Forgery
        // Non préconisé pour les API REST en stateless.
        // Sauf pour POST, PUT, PATCH et DELETE
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.cors(Customizer.withDefaults());

        http.headers(headers -> headers
                .contentSecurityPolicy(csp -> csp
                        .policyDirectives(
                                "default-src 'self'; " +
                                        "script-src 'self'; " +
                                        "style-src 'self'; " +
                                        "img-src 'self' data:; " +
                                        "font-src 'self'; " +
                                        "connect-src 'self' http://localhost:4000 http://localhost:8080" // en prod : connect-src 'self' https://mon-domaine.com
                        )
                )
                .frameOptions(HeadersConfigurer.FrameOptionsConfig::deny)
        );

        //Connexion de l'utilisateur
        http.authenticationProvider(authenticationProvider);

        //Activer le filtre JWT et l'authentication de l'utilisateur
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        //http.formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:4200"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*")); // A remplacer en prod par : "https://ton-front.com"
        config.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
