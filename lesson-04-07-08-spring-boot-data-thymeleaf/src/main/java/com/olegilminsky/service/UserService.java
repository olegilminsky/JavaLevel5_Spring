package com.olegilminsky.service;

import com.olegilminsky.controller.UserListParams;
import com.olegilminsky.persist.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Page<User> findWithFilter(UserListParams userListParams);

    Optional<User> findById(Long id);

    void save(User user);

    void deleteById(Long id);

}