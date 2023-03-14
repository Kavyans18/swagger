package com.pws.APIDoc.service;

import com.pws.APIDoc.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User updateUser(User user, int id);
    User getUserById(int id);
    List<User> getAll();
    void deleteUser(int id);
}
