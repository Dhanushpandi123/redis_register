package com.redis_register.redis_register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisRegisterApplication.class, args);
	}

}
