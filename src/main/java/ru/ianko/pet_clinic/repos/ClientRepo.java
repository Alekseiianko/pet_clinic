package ru.ianko.pet_clinic.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ianko.pet_clinic.domain.Client;

@Repository
public interface ClientRepo extends CrudRepository <Client, Long>  {
}
