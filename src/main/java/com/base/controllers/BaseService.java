package com.base.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.base.db.BaseRepository;
import com.base.objects.AuditModel;

@Service
public class BaseService<T extends AuditModel> {
    
    private final BaseRepository<T> repository;

    @Autowired
    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public T create(T obj) {
        return repository.save(obj);
    }

    public T find(String id) {
        Optional<T> optionalObj = repository.findById(id);

        if (optionalObj.isPresent()) {
            return optionalObj.get();
        }

        return null;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T update(T obj) {
        return repository.save(obj);
    }

    public boolean delete(String id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
}
