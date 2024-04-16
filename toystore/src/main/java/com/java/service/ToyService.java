package com.java.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.Model.User;
import com.java.repository.ToyRepository;

import java.util.List;

@Service
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;
    
    public Page<User> getAllToy(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return toyRepository.findAll(pageable);
    }

    public User createToy(@NonNull User toy) {
        return toyRepository.save(toy);
    }

    public List<User> getAllToys() {
        return toyRepository.findAll();
    }

    public User getToyById(@NonNull Integer id) {
        return toyRepository.findById(id).orElse(null);
    }

    public boolean updateToy(int id, User toy) {
        if (getToyById(id) == null) {
            return false;
        }
        try {
            toyRepository.save(toy);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteToy(int id) {
        if (getToyById(id) == null) {
            return false;
        }
        toyRepository.deleteById(id);
        return true;
    }
}
