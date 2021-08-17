package com.olegilminsky.rest;

import com.olegilminsky.controller.NotFoundException;
import com.olegilminsky.controller.UserDto;
import com.olegilminsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public UserDto findById(@PathVariable("id") Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Secured("ROLE_SUPER_ADMIN")
    @PostMapping(produces = "application/json")
    public UserDto create(@RequestBody UserDto user) {
        if (user.getId() != null) {
            throw new BadRequestException("User Id should be null");
        }
        userService.save(user);
        return user;
    }

    @Secured("ROLE_SUPER_ADMIN")
    @PutMapping(produces = "application/json")
    public void update(@RequestBody UserDto user) {
        if (user.getId() == null) {
            throw new BadRequestException("User Id should`t be null");
        }
        userService.save(user);
    }

    @Secured("ROLE_SUPER_ADMIN")
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
