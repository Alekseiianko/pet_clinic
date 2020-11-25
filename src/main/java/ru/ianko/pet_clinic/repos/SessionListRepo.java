package ru.ianko.pet_clinic.repos;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ianko.pet_clinic.domain.SessionList;

@Repository
public interface SessionListRepo extends CrudRepository <SessionList, Long>  {
}
