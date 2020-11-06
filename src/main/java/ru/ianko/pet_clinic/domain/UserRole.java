package ru.ianko.pet_clinic.domain;

import javax.persistence.*;

/**
 * Класс для создания таблицы user_role. Необходим для присвоения клиенту роли, в целях
 * возможности или невозможности корректирования разных моментов.
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role", unique = true, nullable = false)
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
