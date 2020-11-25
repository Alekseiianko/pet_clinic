package ru.ianko.pet_clinic.domain;

import org.springframework.test.context.jdbc.Sql;

import javax.persistence.*;
import java.util.Date;

/**
 * Класс для создания таблицы pet_medical_card. Необходим доктору для заполнения данных о визите
 * и ведении мед карты для питомца
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "pet_medical_card")
public class PetMedicalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "info", nullable = false)
    private String info;

    @Column(name = "date_of_visit", nullable = false)
    private Date date;

    public PetMedicalCard() {
    }

    public PetMedicalCard(Long id, Doctor doctor, Pet pet, String info, Date date) {
        this.id = id;
        this.doctor = doctor;
        this.pet = pet;
        this.info = info;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
