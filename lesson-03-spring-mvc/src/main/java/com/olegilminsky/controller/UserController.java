package com.olegilminsky.controller;

import com.olegilminsky.persist.User;
import com.olegilminsky.persist.UserRepository;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String listPage(Model model) {
        logger.info("User list page requested");
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        logger.info("New user page requested");
        model.addAttribute("user", new User());
        return "user_form";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        logger.info("Edit user page requested");

        model.addAttribute("user", userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found")));
        return "user_form";
    }

    @PostMapping
    public String update(@Valid User user, BindingResult result) {
        logger.info("Saving user");

        if (result.hasErrors()){
            return "user_form";
        }

        userRepository.save(user);
        return "redirect:/user";
    }

    @ExceptionHandler
    public ModelAndView NotFoundExceptionHandler(NotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("not_found");
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}
