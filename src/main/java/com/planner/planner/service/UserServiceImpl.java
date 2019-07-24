package com.planner.planner.service;

import com.planner.planner.entity.User;
import com.planner.planner.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAllWithTasks() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User findByIdWithTasks(Long id) {
        return null;
    }
}
