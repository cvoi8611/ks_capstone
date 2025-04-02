package com.StudyBuddy.calender.Controller;

import com.StudyBuddy.calender.Entity.Event;
import com.StudyBuddy.calender.Entity.User;
import com.StudyBuddy.calender.Service.EventService;
import com.StudyBuddy.calender.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventRestController {

    @Autowired
    private EventService eventService;


    private final String API_URL = "http://openapi.q-net.or.kr/api/service/rest/InquiryTestInformationNTQSVC/";

    /*
    // READ (GET)
    // getPEList
    @Value("${service.key}")
    private String API_KEY;

    @RequestMapping("/getPEList")
    public List<Map<String, Object>> getPEList() {
        RestTemplate restTemplate = new RestTemplate();

        // JSON 데이터를 Map으로 변환
        Map<String, Object> response = restTemplate.getForObject(API_URL, Map.class);

        // 필요한 데이터 추출
        Map<String, Object> body = (Map<String, Object>) response.get("body");
        Map<String, Object> items = (Map<String, Object>) body.get("items");
        return (List<Map<String, Object>>) items.get("item");
    }
    */

    //@RequestMapping
    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event){
        Event savedEvent = eventService.createEvent(event);
        return eventService.createEvent(savedEvent);
    }

    // READ (GET)
    @RequestMapping("/readAll")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @RequestMapping("/read/{id}")
    public Optional<Event> getEventById(@PathVariable Integer id) {
        return eventService.getEventById(id);
    }

    @RequestMapping("/read/{user_id}")
    public List<Event> getEventByUserId(@PathVariable Integer user_id) {
        return eventService.getEventByUserId(user_id);
    }

    // UPDATE (PUT)
    @RequestMapping("/update/{id}")
    public Event updateEvent(@PathVariable Integer id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    // DELETE (DELETE)
    @RequestMapping("/delete/{id}")
    public void deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
    }

}
