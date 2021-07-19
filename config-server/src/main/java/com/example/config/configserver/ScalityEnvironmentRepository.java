package com.example.config.configserver;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.server.config.ConfigServerProperties;
import org.springframework.cloud.config.server.environment.AwsS3EnvironmentProperties;
import org.springframework.cloud.config.server.environment.AwsS3EnvironmentRepository;
import org.springframework.cloud.config.server.environment.AwsS3EnvironmentRepositoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalityEnvironmentRepository {

    @Autowired
    private ConfigServerProperties server;

    @Autowired
    AwsS3EnvironmentRepositoryFactory awsS3EnvironmentRepositoryFactory;

    @Autowired
    AwsS3EnvironmentProperties awsS3EnvironmentProperties;

    @Bean
    AwsS3EnvironmentRepository getAwsS3EnvironmentRepository() {

        AwsClientBuilder.EndpointConfiguration config = new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", "sa-east-1");

        AmazonS3 client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(config)
                .withPathStyleAccessEnabled(true)
                .build();

        AwsS3EnvironmentRepository repository = new AwsS3EnvironmentRepository(client,
                awsS3EnvironmentProperties.getBucket(), server);

        return  repository;
    }
}