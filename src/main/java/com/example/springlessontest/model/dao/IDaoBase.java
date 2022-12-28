package com.example.springlessontest.model.dao;

import java.util.List;
import java.util.Optional;

public interface IDaoBase<E> {
    List<E> findAll();
    Optional findById(Integer id);
    E save(E item);
    E update(E item);
    E delete(Integer id);
}
