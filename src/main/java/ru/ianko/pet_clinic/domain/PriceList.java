package ru.ianko.pet_clinic.domain;

import org.springframework.test.context.jdbc.Sql;

import javax.persistence.*;

/**
 * Класс для создания таблицы price_list. Отдает данные цена и название услуги
 * при заполнении SessionList клиентом
 * Так же сортирует докторов по айди при выборе той или иной услуге
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "price_list")
public class PriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service", unique = true, nullable = false)
    private String service;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_position_id")
    private DoctorPosition doctorPosition;

    public PriceList() {
    }

    public PriceList(Long id, String service, Integer price, DoctorPosition doctorPosition) {
        this.id = id;
        this.service = service;
        this.price = price;
        this.doctorPosition = doctorPosition;
    }

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
