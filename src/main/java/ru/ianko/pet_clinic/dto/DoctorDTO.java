package ru.ianko.pet_clinic.dto;

import ru.ianko.pet_clinic.domain.Clinic;
import ru.ianko.pet_clinic.domain.DoctorPosition;

/**
 * DTO для Doctor -> для взаимодействия с Controller'ами и Service
 * @autor Aleksei Ianko
 */
public class DoctorDTO {

    private Long id;
    private String name;
    private DoctorPosition doctorPosition;
    private String phone;
    private Clinic clinic;
    private Integer cabinet;

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

    public DoctorDTO(Long id, String name, DoctorPosition doctorPosition,
                     String phone, Clinic clinic, Integer cabinet) {
        this.id = id;
        this.name = name;
        this.doctorPosition = doctorPosition;
        this.phone = phone;
        this.clinic = clinic;
        this.cabinet = cabinet;
    }

    public DoctorDTO() {
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doctorPosition=" + doctorPosition +
                ", phone='" + phone + '\'' +
                ", clinic=" + clinic +
                ", cabinet=" + cabinet +
                '}';
    }
}
