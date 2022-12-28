package com.example.springlessontest.model.dao.repository;

import com.example.springlessontest.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    Optional<Client> findById(Integer id);
}
