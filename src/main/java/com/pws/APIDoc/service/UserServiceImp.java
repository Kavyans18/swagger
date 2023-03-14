package com.pws.APIDoc.service;

import com.pws.APIDoc.entity.User;
import com.pws.APIDoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user, int id) {
        Optional<User> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        User us = optional.get();
        us.setFirstName(user.getFirstName());
        us.setLastName(user.getLastName());
        us.setGender(user.getGender());
        us.setEmail(user.getEmail());
        us.setPhoneNumber(user.getPhoneNumber());
        return repository.save(us);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        return optional.get();
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> optional = repository.findById(id);
        if (optional.isEmpty()) {
            System.out.println("Id not found");
        }
        User us = optional.get();
        repository.delete(us);
    }
}