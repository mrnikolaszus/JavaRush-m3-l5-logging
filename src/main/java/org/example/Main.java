package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.UserServiceException;
import org.example.model.User;
import org.example.repo.UserRepository;
import org.example.repo.UserRepositoryImpl;
import org.example.service.UserService;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

      //  System.out.println("App started!");
        logger.info("App started!");
        UserRepository repository = new UserRepositoryImpl();
        logger.trace("Created repository {}", repository);

        UserService service = new UserService(repository);
        logger.trace("Created service {}", service);
        User user = new User();

        long id = 1L;

        user.setId(id);
        user.setName("John Snow");

        try{
            service.add(user);
            service.add(user);
            service.add(user);
        } catch (UserServiceException e){
            logger.error("user service error!!!", e);
   //         System.err.println("user service error!!!" + e);
        }

        User userFromRepo = repository.getById(id);
 //       System.out.println("Get user: " + userFromRepo);
        logger.info("Get user: {}", userFromRepo);

   //    System.out.println("App finished!");
        logger.info("App finished!");
    }
}