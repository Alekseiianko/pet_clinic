package ru.ianko.pet_clinic.domain;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
