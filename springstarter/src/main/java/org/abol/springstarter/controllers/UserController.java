package org.abol.springstarter.controllers;


import org.abol.springstarter.models.BaseUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    private List<BaseUser> users = new ArrayList<>();


    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("baseUser", new BaseUser());
        return "register";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("baseUser") BaseUser baseUser, Model model) {
        users.add(baseUser);
        model.addAttribute("baseUser", baseUser);
        return "userDetails";
    }


    @GetMapping("/userDetails")
    public String baseUserDetails(@RequestParam(name="index", required=false) Integer index, Model model) {
        if (index != null && index < users.size()) {
            model.addAttribute("baseUser", users.get(index));
        } else {
            model.addAttribute("baseUser", new BaseUser());
        }
        return "userDetails";
    }


    @GetMapping("/allUsers")
    public String displayAll(Model model) {
        model.addAttribute("users", users);
        return "allUsers";
    }

}
