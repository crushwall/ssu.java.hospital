package com.hospital.repository;

import com.hospital.entity.Client;
import com.hospital.entity.PatientCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientCardRepository extends CrudRepository<PatientCard, Long> {
    PatientCard findByClient(Client client);

    Optional<PatientCard> findById(long id);

    void deleteById(long id);
}
