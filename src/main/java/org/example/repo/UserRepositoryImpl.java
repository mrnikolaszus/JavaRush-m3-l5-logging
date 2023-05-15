package org.example.repo;

import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{

    public final Map<Long, User> map = new HashMap<>();

    @Override
    public User getById(long id) {
        User user = map.get(id);
        return user;
    }

    @Override
    public Boolean findUser(User user) {
       return map.containsKey(user.getId());


    }

    @Override
    public Boolean tryToSave(User user) {
        map.put(user.getId(), user);
        return true;
    }

    @Override
    public String toString() {
        return "UserRepositoryImpl{" +
                "map=" + map +
                '}';
    }
}
