package org.example.service;

import org.example.exceptions.UserServiceException;
import org.example.model.User;
import org.example.repo.UserRepository;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean add(User user){
        if(!repository.findUser(user)){
            Boolean save = repository.tryToSave(user);
            return save;
        } else {
            UserServiceException e = new UserServiceException("user already exists");
            throw e;
        }
    }

    @Override
    public String toString() {
        return "UserService{" +
                "repository=" + repository +
                '}';
    }
}
