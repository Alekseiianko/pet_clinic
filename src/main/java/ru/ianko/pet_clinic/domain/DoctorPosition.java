package ru.ianko.pet_clinic.domain;

import org.springframework.test.context.jdbc.Sql;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс для создания таблицы doctor_position. Необходим для привязки объектов Doctor к конкретным услугам
 * в PriceList
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "doctor_position")
public class DoctorPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position", unique = true, nullable = false)
    private String position;

    public DoctorPosition() {
    }

    public DoctorPosition(Long id, String position) {
        this.id = id;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return position ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorPosition that = (DoctorPosition) o;
        return id.equals(that.id) &&
                position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position);
    }
}
