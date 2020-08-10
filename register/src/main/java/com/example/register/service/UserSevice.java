package com.example.register.service;

import com.example.register.model.User;

public interface UserSevice {
    void save(User user);
    User findByUsername(String username);
}
