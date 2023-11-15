package com.springboot3;

import com.springboot3.client.ProductClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class Springboot3FeaturesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3FeaturesApplication.class, args);
	}

	@Bean
	public ProductClient productClient(){
		String baseUri = "https://6554a6f963cafc694fe6c169.mockapi.io/api/products";
		RestClient restClient = RestClient.create(baseUri);

		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(ProductClient.class);

	}

}
