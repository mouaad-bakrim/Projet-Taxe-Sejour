package com.example.demo.service.facade;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;

import java.util.List;

public interface UserFacade {
        User saveUser(User user);
        Role saveRole(Role role);
        void addRoleToUser(String username, String roleName);
        User getUser(String username);
        List<User> getUsers();
    }
