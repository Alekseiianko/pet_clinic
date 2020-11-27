package ru.ianko.pet_clinic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import ru.ianko.pet_clinic.domain.Clinic;
import ru.ianko.pet_clinic.domain.Doctor;
import ru.ianko.pet_clinic.domain.DoctorPosition;
import ru.ianko.pet_clinic.repos.DoctorRepo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {ForTest.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class DoctorTest {

    @Resource
    private DoctorRepo doctorRepo;

    @Test
    public void compareTwoList_byClinicId() {
        List<Doctor> listForTestRepoMethod = doctorRepo.findDoctorByClinicId((long) 1);
        List<Doctor> doctorList = new ArrayList<>();
        Clinic clinic = new Clinic((long) 1, "г.Санкт-Петербург, пр.Королева, д.57",
                "Пн-пт 10-19", "+7(812)123-45-67");
        DoctorPosition dP1 = new DoctorPosition((long) 1, "Хирург");
        DoctorPosition dP2 = new DoctorPosition((long) 2, "Врач общей практики");

        Doctor doctor = new Doctor((long) 1, "Иванова Галина Петровна", dP1,
                "+79153255050", clinic, 34);
        Doctor doctor2 = new Doctor((long) 2, "Петров Роман Алексеевич", dP2,
                "+79153255051", clinic, 31);

        doctorList.add(doctor);
        doctorList.add(doctor2);


        Assert.assertTrue(listForTestRepoMethod.equals(doctorList));
    }
}
