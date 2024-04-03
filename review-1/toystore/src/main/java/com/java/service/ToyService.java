package com.java.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.Model.*;
import com.java.repository.*;
@Service
public class ToyService {
    @Autowired
    private ToyRepository toyRepository;

    public User createuser(User a){
        return toyRepository.save(a);
    }

    public List<User> getAllusers(){
        return toyRepository.findAll();
    }

    public Optional<User> getuserById(Integer userId){
        return toyRepository.findById(userId);
    }
    public void deleteUser(Integer userId) {
        toyRepository.deleteById(userId);
    }
    public void updateUser(User user) {
        toyRepository.save(user);
    }
}