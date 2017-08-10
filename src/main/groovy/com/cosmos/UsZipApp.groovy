package com.cosmos

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
class UsZipApp {
    static void main(String[] args) {
        SpringApplication.run(UsZipApp.class, args)
    }
}



