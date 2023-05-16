package org.example.service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.example.exceptions.UserServiceException;
import org.example.model.User;
import org.example.repo.UserRepository;

@Slf4j
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean add(User user){
        if(!repository.findUser(user)){
            Boolean save = repository.tryToSave(user);
            log.info("Add user {} from server {}", user, this );
            return save;
        } else {
            UserServiceException e = new UserServiceException("user already exists");
            log.error("User {} already exists!", user);
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
