package com.planner.planner.service;

import com.planner.planner.entity.Role;
import com.planner.planner.entity.User;
import com.planner.planner.repository.RoleRepo;
import com.planner.planner.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private final RoleRepo roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
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
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User findByIdWithTasks(Long id) {
        return null;
    }

    @Override
    public User findByUserName(String username) {
        return userRepo.findByUsername(username);
    }
    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepo.save(user);
    }

}
