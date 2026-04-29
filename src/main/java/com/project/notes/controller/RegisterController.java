//package com.project.notes.controller;
//
//import com.project.notes.model.User;
//import com.project.notes.service.RegisterService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@Controller
//public class RegisterController {
//    private final RegisterService registerService;
//
//    public RegisterController(RegisterService registerService) {
//        this.registerService = registerService;
//    }
//
//    @GetMapping ("/register")
//    public String register(){
//        return "register";
//    }
//
//    @PostMapping ("/register")
//    public String register (@RequestParam String username, String password, Model model){
//        User user = registerService.registerUser (username, password);
//        if (user != null) {
//            return "redirect:/success";
//        }
//        model.addAttribute("error", "Could not create user, please try again");
//        return "register";
//
//    }
//
//    @GetMapping ("/success")
//    public String successPage(){
//        return "success";
//    }
//
//}
