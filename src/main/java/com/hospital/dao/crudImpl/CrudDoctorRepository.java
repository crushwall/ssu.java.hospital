package com.hospital.dao.crudImpl;

import com.hospital.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudDoctorRepository extends CrudRepository<Doctor, Integer> {
}
