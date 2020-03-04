package com.devon.treditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devon.treditor.mongo.Domain;
import com.devon.treditor.mongo.DomainRepository;

@SpringBootApplication
public class TreditorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreditorApplication.class, args);
	}

	@RequestMapping("/")
	public String handle(DomainRepository domainRepository) {
		Domain obj2 = domainRepository.findFirstByDomain("mkyong.com");
		System.out.println(obj2);

		int n = domainRepository.updateDomain("mkyong.com", true);
		System.out.println("Number of records updated : " + n);
		return String.valueOf(n);
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {

		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);

		return mongoTemplate;

	}
}