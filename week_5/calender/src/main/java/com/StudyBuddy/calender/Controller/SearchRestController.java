package com.StudyBuddy.calender.Controller;

import com.StudyBuddy.calender.Entity.API_Event;
import com.StudyBuddy.calender.Entity.Event;
import com.StudyBuddy.calender.Service.API_EventService;
import com.StudyBuddy.calender.Service.EventService;
import com.StudyBuddy.calender.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchRestController {

    @Autowired
    private API_EventService api_eventService;

    // READ (GET)
    @RequestMapping("/getAllAPIEvents")
    public List<API_Event> getAllEvents() {
        return api_eventService.getAllEvents();
    }
}
