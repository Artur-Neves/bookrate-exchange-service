package br.com.neves.exchange_service.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.reporter.Sender;
import zipkin2.reporter.urlconnection.URLConnectionSender;

@Configuration
public class ZipkinConfiguration {
    @Value("${spring.zipkin.base-url:http://localhost:9411}")
    public String zipkinUrl;

    @Bean
    public Sender zipkinConfigurationSenderSender(){
        String endpoint = zipkinUrl+ "/api/v2/spans";
        return URLConnectionSender.newBuilder().endpoint(endpoint).build();
    }
}
