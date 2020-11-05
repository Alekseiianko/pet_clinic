package ru.ianko.pet_clinic.domain;

import javax.persistence.*;

@Entity
@Table(name = "doctor_position")
public class DoctorPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "position", unique = true, nullable = false)
    private String position;

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
}
