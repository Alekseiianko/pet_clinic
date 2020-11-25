package ru.ianko.pet_clinic.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ianko.pet_clinic.domain.Doctor;


import java.util.List;


public interface DoctorRepo extends CrudRepository<Doctor, Long>  {
    @Query(value = "SELECT d from Doctor d where d.clinic.id= :clinicId")
    List <Doctor> findDoctorByClinicId(@Param("clinicId") Long clinicId);

}
