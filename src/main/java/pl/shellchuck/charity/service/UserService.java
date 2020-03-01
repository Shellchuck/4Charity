package pl.shellchuck.charity.service;

import pl.shellchuck.charity.entity.User;

public interface UserService {

    void addUser(User user);

    User findByUserName(String name);

}
