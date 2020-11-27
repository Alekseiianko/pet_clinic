package ru.ianko.pet_clinic.domain;

import org.springframework.test.context.jdbc.Sql;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс для создания таблицы doctor. Необходим для клиента при создании записи,
 * а так же для заполнения pet_medical_card после посещения
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_position_id")
    private DoctorPosition doctorPosition;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @Column(name = "cabinet", nullable = false)
    private Integer cabinet;

    public Doctor() {
    }

    public Doctor(Long id, String name, DoctorPosition doctorPosition,
                  String phone, Clinic clinic, Integer cabinet) {
        this.id = id;
        this.name = name;
        this.doctorPosition = doctorPosition;
        this.phone = phone;
        this.clinic = clinic;
        this.cabinet = cabinet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoctorPosition getDoctorPosition() {
        return doctorPosition;
    }

    public void setDoctorPosition(DoctorPosition doctorPosition) {
        this.doctorPosition = doctorPosition;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Integer getCabinet() {
        return cabinet;
    }

    public void setCabinet(Integer cabinet) {
        this.cabinet = cabinet;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doctorPosition=" + doctorPosition +
                ", phone='" + phone + '\'' +
                ", clinic=" + clinic +
                ", cabinet=" + cabinet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id.equals(doctor.id) &&
                name.equals(doctor.name) &&
                doctorPosition.equals(doctor.doctorPosition) &&
                phone.equals(doctor.phone) &&
                clinic.equals(doctor.clinic) &&
                cabinet.equals(doctor.cabinet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, doctorPosition, phone, clinic, cabinet);
    }
}
