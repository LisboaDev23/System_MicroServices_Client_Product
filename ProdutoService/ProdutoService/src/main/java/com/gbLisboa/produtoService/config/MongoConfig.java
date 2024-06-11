package com.gbLisboa.produtoService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.gbLisboa.produtoService.service.repository")
public class MongoConfig {

}
