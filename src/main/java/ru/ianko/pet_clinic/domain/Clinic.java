package ru.ianko.pet_clinic.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс для создания таблицы clinic. Необходим для привязки врачей к конкретной клинике,
 * а так же при создании записи клиента для отображение адреса
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address", unique = true, nullable = false)
    private String address;

    @Column(name = "schedule_clinic", nullable = false)
    private String scheduleClinic;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    public Clinic() {
    }

    public Clinic(Long id, String address, String scheduleClinic, String phone) {
        this.id = id;
        this.address = address;
        this.scheduleClinic = scheduleClinic;
        this.phone = phone;
    }

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

    @Override
    public String toString() {
        return "Clinic{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", scheduleClinic='" + scheduleClinic + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return id.equals(clinic.id) &&
                address.equals(clinic.address) &&
                scheduleClinic.equals(clinic.scheduleClinic) &&
                phone.equals(clinic.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, scheduleClinic, phone);
    }
}
