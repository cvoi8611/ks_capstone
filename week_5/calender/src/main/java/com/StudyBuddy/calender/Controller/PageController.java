package com.StudyBuddy.calender.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }

//    @GetMapping("/register")
//    public String register() {
//        return "forward:/register.html";
//    }
//
//    @GetMapping("/login")
//    public String login(){
//        return "forward:/login.html";
//    }
//
//    @GetMapping("/logout")
//    public String logout() {
//        return "forward:/logout.html";
//    }
//
//    @GetMapping("/calendar")
//    public String cal() {
//        return "forward:/calendar.html";
//    }
//
//    @GetMapping("/api_event")
//    public String apiEvent() {
//        return "forward:/api_event.html";
//    }
//
//    @GetMapping("/event")
//    public String getEventPage() {
//        return "forward:/event.html";
//    }
}