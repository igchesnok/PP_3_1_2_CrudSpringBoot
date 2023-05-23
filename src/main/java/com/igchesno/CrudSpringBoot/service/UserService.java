package com.igchesno.CrudSpringBoot.service;

import com.igchesno.CrudSpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createOrUpdateUser(User user);
    User readUser(long id);
    void deleteUser(long id);
}
