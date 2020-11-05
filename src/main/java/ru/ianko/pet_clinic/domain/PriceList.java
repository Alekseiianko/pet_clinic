package ru.ianko.pet_clinic.domain;

import javax.persistence.*;

@Entity
@Table(name = "price_list")
public class PriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "service", unique = true, nullable = false)
    private String service;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_position_id")
    private DoctorPosition doctorPosition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public DoctorPosition getDoctorPosition() {
        return doctorPosition;
    }

    public void setDoctorPosition(DoctorPosition doctorPosition) {
        this.doctorPosition = doctorPosition;
    }
}
