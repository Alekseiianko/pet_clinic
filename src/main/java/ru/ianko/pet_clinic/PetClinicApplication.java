package ru.ianko.pet_clinic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class PetClinicApplication implements CommandLineRunner {

    Logger logger = Logger.getLogger(
            PetClinicApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
