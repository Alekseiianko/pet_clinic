package ru.ianko.pet_clinic.domain;

import org.springframework.test.context.jdbc.Sql;

import javax.persistence.*;
import java.util.Date;

/**
 * Класс для создания таблицы session_list.
 * Необходим для заполнения Client в целях создания
 * записи . Подтягивает информацию с остальным таблиц и на их основе формирует
 * ЦЕЛОСТНУЮ запись
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "session_list")
public class SessionList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "date_of_visit", nullable = false)
    private Date date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "price_list_id")
    private PriceList priceList;

    public SessionList() {
    }

    public SessionList(Long id, Client client, Clinic clinic,
                       Doctor doctor, Date date, PriceList priceList) {
        this.id = id;
        this.client = client;
        this.clinic = clinic;
        this.doctor = doctor;
        this.date = date;
        this.priceList = priceList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }
}
