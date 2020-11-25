package ru.ianko.pet_clinic.domain;

import org.springframework.test.context.jdbc.Sql;

import javax.persistence.*;

/**
 * Класс для создания таблицы pet.
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "age", nullable = false)
    private Integer age;

    public Pet() {
    }

    public Pet(Long id, PetType petType, String name, Client client, Integer age) {
        this.id = id;
        this.petType = petType;
        this.name = name;
        this.client = client;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
