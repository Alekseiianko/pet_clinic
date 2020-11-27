package ru.ianko.pet_clinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ianko.pet_clinic.PetClinicApplication;
import ru.ianko.pet_clinic.dto.DoctorDTO;
import ru.ianko.pet_clinic.service.DoctorService;

import java.util.List;
import java.util.logging.Logger;

/**
 * Controller сущности Doctor, который работает с DoctorDTO
 * и возвращает в front запрашиваемую информацию
 * @autor Aleksei Ianko
 */

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private Logger logger = Logger.getLogger(
            DoctorController.class.getName());

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    /**
     * Метод возвращающий список объектов DoctorDto при Get-запросе.
     */
    @GetMapping
    public ResponseEntity<List<DoctorDTO>> doctorDtoAll(){
        logger.info("Find all doctor");
        return new ResponseEntity<>(doctorService.findAllDoctorDto(), HttpStatus.OK);
    }

    /**
     * Метод возвращающий список объектов DoctorDto
     * которых находит по id клиники при Get-запросе.
     */
    @GetMapping("/clinic/{clinicId}")
    public ResponseEntity<List<DoctorDTO>> doctorDtoByClinicId(@PathVariable long clinicId) {
        logger.info("Find doctor by clinic ID");
        List<DoctorDTO> dtoList = doctorService.findDoctorDtoByClinicId(clinicId);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
