package com.planner.planner.controller;

import com.planner.planner.entity.User;
import com.planner.planner.service.CurrentUser;
import com.planner.planner.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-user")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/create-user")
    public String createUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()){
            return "create-user";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }

//    @GetMapping("/admin")
//    @ResponseBody
//    public String userInfo(@AuthenticationPrincipal UserDetails customUser) {
////        log.info("customUsSer class {} "
////                , customUser.getClass());
//        return "You are logged as " + customUser;
//    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername() + ", " + entityUser.getId();
    }

}