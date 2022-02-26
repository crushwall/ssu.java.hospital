package com.hospital.repository;

import com.hospital.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Optional<Doctor> findById(long id);

    Optional<Doctor> findByUsername(String username);

    void deleteById(long id);
}
