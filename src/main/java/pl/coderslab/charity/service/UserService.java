package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.User;

public interface UserService {
    User findByUserName(String username);

    void saveUser(User user);

    void update(User user);

    void delete(Long id);


}