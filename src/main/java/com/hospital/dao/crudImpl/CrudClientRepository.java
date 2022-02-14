package com.hospital.dao.crudImpl;

import com.hospital.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudClientRepository extends CrudRepository<Client, Integer> {
}
