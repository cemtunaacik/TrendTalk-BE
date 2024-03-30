package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    Optional<User> findByNickname(String nickname);
}
