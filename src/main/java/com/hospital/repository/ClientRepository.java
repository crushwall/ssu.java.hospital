package com.hospital.repository;

import com.hospital.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findById(long id);

    Optional<Client> findByUsername(String username);

    void deleteById(long id);
}