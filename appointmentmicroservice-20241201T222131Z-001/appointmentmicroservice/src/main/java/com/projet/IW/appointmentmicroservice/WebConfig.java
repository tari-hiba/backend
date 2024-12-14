package com.projet.IW.appointmentmicroservice;  // Le package où se trouve cette classe

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // Indique que cette classe contient une configuration Spring
public class WebConfig {

    // Configure CORS pour autoriser les requêtes venant de votre application Angular (localhost:4200)
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // On ajoute une règle de CORS pour autoriser les requêtes depuis Angular
                registry.addMapping("/**")  // Applique cette règle à toutes les API du backend
                        .allowedOrigins("http://localhost:4200")  // Autorise Angular à faire des requêtes
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Liste des méthodes HTTP autorisées
                        .allowedHeaders("*")  // Autorise tous les types de headers
                        .allowCredentials(true);  // Permet d'envoyer des informations d'authentification (cookies, etc.)
            }
        };
    }
}
