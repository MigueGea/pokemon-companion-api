package com.miguegea.pokemoncompanion.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@EnableConfigurationProperties(PokemonApiProperties.class)
public class RestClientConfig {

    @Bean
    public RestClient restClient(PokemonApiProperties properties) {
        return  RestClient.builder().baseUrl(properties.baseUrl()).build();
    }
}
