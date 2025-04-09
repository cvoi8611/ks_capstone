package com.StudyBuddy.calender.Service;

import com.StudyBuddy.calender.Entity.Event;
import com.StudyBuddy.calender.Entity.EventRepository;
import com.StudyBuddy.calender.Entity.User;
import com.StudyBuddy.calender.Entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // CREATE
    public Event createEvent(Event event){
        return eventRepository.save(event);
    }

    // READ
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Integer id){
        return eventRepository.findById(id);
    }

    public List<Event> getEventByUserId(Integer user_id){
        return eventRepository.findEventByUserId(user_id);
    }


    // UPDATE
    public Event updateEvent(Integer id, Event updatedEvent){
        return eventRepository.findById(id)
                .map(event -> {
                    event.setTitle(updatedEvent.getTitle());
                    event.setDescription(updatedEvent.getDescription());
                    event.setPlace(updatedEvent.getPlace());
                    event.setStartTime(updatedEvent.getStartTime());
                    event.setEndTime(updatedEvent.getEndTime());
                    return eventRepository.save(event);
                })
                .orElseThrow(() -> new RuntimeException("Event Not Found"));
    }

    // DELETE
    public void deleteEvent(Integer id){
        eventRepository.deleteById(id);
    }
}