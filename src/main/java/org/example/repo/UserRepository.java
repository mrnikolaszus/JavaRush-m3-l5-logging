package org.example.repo;

import org.example.model.User;

public interface UserRepository {

    User getById(long id);

    Boolean findUser(User user);

    Boolean tryToSave(User user);

}
