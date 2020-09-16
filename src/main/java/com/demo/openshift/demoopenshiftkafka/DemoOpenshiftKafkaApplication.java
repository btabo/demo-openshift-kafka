package com.demo.openshift.demoopenshiftkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(GreetingsStreams.class)
public class DemoOpenshiftKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOpenshiftKafkaApplication.class, args);
	}

}
