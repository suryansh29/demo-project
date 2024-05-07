package com.project.demo1;

import com.project.demo1.entities.User;
import com.project.demo1.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository) throws Exception {
        return (String[] args) -> {
            User user1 = new User("John", "john@domain.com");
            User user2 = new User("Julie", "julie@domain.com");
            User user3 = new User("Julie", "julie@domain.com");
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            Random random = new Random();
            int randomWithNextInt = random.nextInt();
            for(int i = 0; i < 10; i++){
                User userR = new User("John"+ randomWithNextInt, "john@domain.com");
                userRepository.save(userR);
            }
            userRepository.findAll().forEach(user -> System.out.println(user));
        };
    }

}
