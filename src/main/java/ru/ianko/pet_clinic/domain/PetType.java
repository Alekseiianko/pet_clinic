package ru.ianko.pet_clinic.domain;

import javax.persistence.*;

/**
 * Класс для создания таблицы pet_type. Необходим для присвоения типа питомца к объекту класса Pet
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "pet_type")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type", unique = true, nullable = false)
    private String type;

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
