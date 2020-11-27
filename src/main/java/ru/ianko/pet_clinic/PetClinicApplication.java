package ru.ianko.pet_clinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.ianko.pet_clinic.controller.DoctorController;
import ru.ianko.pet_clinic.domain.Doctor;
import ru.ianko.pet_clinic.repos.DoctorRepo;

import java.util.logging.Logger;

@SpringBootApplication
public class PetClinicApplication implements CommandLineRunner {

    private Logger logger = Logger.getLogger(
            PetClinicApplication.class.getName());

    @Autowired
    private DoctorController doctorController;

    @Autowired
    private DoctorRepo doctorRepo;

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("_________________________");
        logger.info(String.valueOf(doctorRepo.findDoctorByClinicId((long)1)));
    }
}
