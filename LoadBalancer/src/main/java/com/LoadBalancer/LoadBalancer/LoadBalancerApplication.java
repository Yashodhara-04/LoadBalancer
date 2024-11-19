package com.LoadBalancer.LoadBalancer;

import com.LoadBalancer.LoadBalancer.Client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoadBalancerApplication {

	public static void main(String[] args) {
		Client client = new Client();
		client.runApplication();
		SpringApplication.run(LoadBalancerApplication.class, args);
	}

}
