package com.expensesharing.expense_sharing_app.service;

import com.expensesharing.expense_sharing_app.entity.User;
import com.expensesharing.expense_sharing_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // light coupling ke liye h dependies injection

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
