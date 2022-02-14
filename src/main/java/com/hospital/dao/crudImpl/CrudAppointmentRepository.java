package com.hospital.dao.crudImpl;

import com.hospital.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudAppointmentRepository extends CrudRepository<Appointment, Integer> {
}
