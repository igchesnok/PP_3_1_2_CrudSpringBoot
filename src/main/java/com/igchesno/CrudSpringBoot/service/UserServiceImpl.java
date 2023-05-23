package com.igchesno.CrudSpringBoot.service;

import com.igchesno.CrudSpringBoot.model.User;
import com.igchesno.CrudSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createOrUpdateUser(User user) {
         userRepository.save(user);
    }

    public User readUser(long id) {
        return userRepository.getReferenceById(id);
    }

    public void deleteUser(long id) {
       userRepository.deleteById(id);
   }
}
