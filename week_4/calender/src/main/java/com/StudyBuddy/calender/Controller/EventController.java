package com.StudyBuddy.calender.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @GetMapping("/event")
    public String getEventPage(){
        return "event";
    }
}
