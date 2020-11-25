package ru.ianko.pet_clinic.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.*;

/**
 * Класс для создания таблицы user_role. Необходим для присвоения клиенту роли, в целях
 * возможности или невозможности корректирования разных данных.
 * @autor Aleksei Ianko
 */

@Entity
@Table(name = "user_role")
public class UserRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", unique = true, nullable = false)
    private String role;

    public UserRole() {
    }

    public UserRole(Long id, String role) {
        this.id = id;
        this.role = role;
    }

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

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
