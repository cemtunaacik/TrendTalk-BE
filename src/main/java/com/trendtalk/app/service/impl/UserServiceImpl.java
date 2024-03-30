package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.entity.User;
import com.trendtalk.app.repository.interfaces.IUser;
import com.trendtalk.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUser userRepository;

    @Autowired
    public UserServiceImpl(IUser userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setNickname(user.getNickname());
                    existingUser.setEmail(user.getEmail());
                    // Additional fields to be updated
                    return userRepository.save(existingUser);
                }).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }
}
