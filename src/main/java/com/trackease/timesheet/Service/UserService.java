package com.trackease.timesheet.Service;

import com.trackease.timesheet.Model.User;
import com.trackease.timesheet.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User getUserByEmail(String email){
        return userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with email: "+ email));
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(Long id){
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: "+ id));
    }
}
