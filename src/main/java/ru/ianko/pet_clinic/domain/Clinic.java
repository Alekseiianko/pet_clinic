package ru.ianko.pet_clinic.domain;

import javax.persistence.*;

@Entity
@Table(name = "clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address", unique = true, nullable = false)
    private String address;

    @Column(name = "schedule_clinic", nullable = false)
    private String scheduleClinic;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getScheduleClinic() {
        return scheduleClinic;
    }

    public void setScheduleClinic(String scheduleClinic) {
        this.scheduleClinic = scheduleClinic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
