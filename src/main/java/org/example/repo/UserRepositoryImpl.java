package org.example.repo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.User;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{
    private  static Logger logger = LogManager.getLogger(UserRepositoryImpl.class);
    java.util.logging.Logger logger2
            = java.util.logging.Logger.getLogger(UserRepositoryImpl.class.getName());

    org.slf4j.Logger loggerSLF = LoggerFactory.getLogger(UserRepositoryImpl.class);




    public final Map<Long, User> map = new HashMap<>();

    @Override
    public User getById(long id) {
        User user = map.get(id);
        logger.info("Get by ID: {}", user);
        return user;
    }

    @Override
    public Boolean findUser(User user) {
       return map.containsKey(user.getId());


    }

    @Override
    public Boolean tryToSave(User user) {
        map.put(user.getId(), user);
        logger.info("Save user: {}", user);
        return true;
    }

    @Override
    public String toString() {
        return "UserRepositoryImpl{" +
                "map=" + map +
                '}';
    }
}
