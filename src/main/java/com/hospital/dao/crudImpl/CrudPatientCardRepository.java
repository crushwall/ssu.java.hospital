package com.hospital.dao.crudImpl;

import com.hospital.entity.Appointment;
import com.hospital.entity.Client;
import com.hospital.entity.PatientCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudPatientCardRepository extends CrudRepository<PatientCard, Integer> {
    public PatientCard findPatientCardByClient(Client client);
}
