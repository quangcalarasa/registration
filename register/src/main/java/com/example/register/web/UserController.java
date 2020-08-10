package com.example.register.web;

import com.example.register.model.User;
import com.example.register.service.SecurityService;
import com.example.register.service.UserSevice;
import com.example.register.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController  {
    @Autowired
    private UserSevice userSevice;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;
    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm",new User());
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userFrom, BindingResult bindingResult){
        userValidator.validate(userFrom,bindingResult);
        if (bindingResult.hasErrors()){
            return "registration";
        }
        userSevice.save(userFrom);
        securityService.autoLogin(userFrom.getUsername(),userFrom.getPasswordConfirm());
        return "redirect:/welcome";
    }
    @GetMapping("/login")
    public String login(Model model,String error,String logout){
        if (error != null){
            model.addAttribute("error","Your username and password is invalid");
        }
        if (logout != null){
            model.addAttribute("message","You have been logged out successfully");
        }
        return  "login";
    }
    @GetMapping({"/","/Welcome"})
    public  String welcome(Model model){
        return "welcome";
    }

}
