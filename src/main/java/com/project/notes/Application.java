package com.project.notes;

import com.project.notes.menu.Menu;
import com.project.notes.repository.UserRepository;
import com.project.notes.service.RegisterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public int start(Menu menuStart) {

        System.out.println("Started!");
        menuStart.menu();

        return 0;
    }

}
