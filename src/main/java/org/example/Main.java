package org.example;

import org.example.exceptions.UserServiceException;
import org.example.model.User;
import org.example.repo.UserRepository;
import org.example.repo.UserRepositoryImpl;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) {

        System.out.println("App started!");
        UserRepository repository = new UserRepositoryImpl();

        UserService service = new UserService(repository);
        User user = new User();

        long id = 1L;

        user.setId(id);
        user.setName("John Snow");

        try{
            service.add(user);
            service.add(user);
            service.add(user);
        } catch (UserServiceException e){
            System.err.println("user service error!!!" + e);
        }

        User userFromRepo = repository.getById(id);
        System.out.println("Get user: " + userFromRepo);

        System.out.println("App finished!");
    }
}