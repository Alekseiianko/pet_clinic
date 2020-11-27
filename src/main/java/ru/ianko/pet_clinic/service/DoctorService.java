package ru.ianko.pet_clinic.service;

import org.springframework.stereotype.Service;
import ru.ianko.pet_clinic.domain.Doctor;
import ru.ianko.pet_clinic.dto.DoctorDTO;
import ru.ianko.pet_clinic.repos.DoctorRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Service сущности Doctor, который работает с DoctorDTO и описывает бизнес логику методов
 * @autor Aleksei Ianko
 */

@Service
public class DoctorService {

    private DoctorRepo doctorRepo;

    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    /**
     * Метод для поиска DoctorDTO по id клиники.
     */
    public List<DoctorDTO> findDoctorDtoByClinicId (long clinicId){
        List <Doctor> doctorList = doctorRepo.findDoctorByClinicId(clinicId);
        return doctorToDoctorDto(doctorList);
    }

    /**
     * Метод для поиска всех DoctorDTO.
     */
    public List<DoctorDTO> findAllDoctorDto(){
        List <Doctor> doctorList = (List<Doctor>) doctorRepo.findAll();
        return doctorToDoctorDto(doctorList);
    }

    /**
     * Метод для конвертации Doctor -> DoctorDto.
     * Необходим для отсутствия дублирования кода.
     * P.S. -> возможно стоит вынести в Parser lol
     */
    private List<DoctorDTO> doctorToDoctorDto(List<Doctor> doctorList){
        List <DoctorDTO> doctorDTOList = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setId(doctor.getId());
            doctorDTO.setName(doctor.getName());
            doctorDTO.setDoctorPosition(doctor.getDoctorPosition());
            doctorDTO.setPhone(doctor.getPhone());
            doctorDTO.setClinic(doctor.getClinic());
            doctorDTO.setCabinet(doctor.getCabinet());
            doctorDTOList.add(doctorDTO);
        }
        return doctorDTOList;
    }
}
