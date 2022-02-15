package com.hospital.repository;

import com.hospital.entity.Client;
import com.hospital.entity.PatientCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudPatientCardRepository extends CrudRepository<PatientCard, Integer> {
    PatientCard findPatientCardByClient(Client client);
}
