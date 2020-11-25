package ru.ianko.pet_clinic.domain;

import org.springframework.test.context.jdbc.Sql;

import javax.persistence.*;

/**
 * Класс для создания таблицы pet_type. Необходим для присвоения типа питомца к объекту класса Pet
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "pet_type")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", unique = true, nullable = false)
    private String type;

    public PetType() {
    }

    public PetType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
