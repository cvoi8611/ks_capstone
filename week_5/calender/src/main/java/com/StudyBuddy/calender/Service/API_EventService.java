package com.StudyBuddy.calender.Service;

import com.StudyBuddy.calender.APIEntity.API_FilteredItem;
import com.StudyBuddy.calender.Entity.API_Event;
import com.StudyBuddy.calender.Entity.API_EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class API_EventService {

    @Autowired
    private API_EventRepository api_eventRepository;

    // 전체 데이터 삭제
    public void deleteAll() {
        api_eventRepository.deleteAll();
    }

    public void saveFilteredItems(List<API_FilteredItem> items) {
        List<API_Event> events = items.stream()
                .map(API_Event::fromDto)
                .collect(Collectors.toList());

        api_eventRepository.saveAll(events);
    }

    public void saveApiEvent(API_Event event){
        api_eventRepository.save(event);
    }

//    public API_Event saveApiEvent(API_Event event){
//        return api_eventRepository.save(event);
//    }

    // CREATE
    /*
    public List<API_FilteredItem> createEvent(List<API_FilteredItem> Filtered_event){
        return api_eventRepository.save(Filtered_event);
    }
    */

    // READ
    public List<API_Event> getAllEvents(){
        return api_eventRepository.findAll();
    }

    public Optional<API_Event> getEventById(Integer id){
        return api_eventRepository.findById(id);
    }

    public List<API_Event> getEventByDescription(String description){
        return api_eventRepository.findAPIEventByDescription(description);
    }


    // UPDATE
    public API_Event updateEvent(Integer id, API_Event updatedEvent){
        return api_eventRepository.findById(id)
                .map(event -> {
                    event.setDescription(updatedEvent.getDescription());

                    event.setDocexamdt(updatedEvent.getDocexamdt());
                    event.setDocpassdt(updatedEvent.getDocpassdt());
                    event.setDocregenddt(updatedEvent.getDocregenddt());
                    event.setDocregstartdt(updatedEvent.getDocregstartdt());

                    event.setDocsubmitentdt(updatedEvent.getDocsubmitentdt());
                    event.setDocsubmitstartdt(updatedEvent.getDocsubmitstartdt());

                    event.setPracexamenddt(updatedEvent.getPracexamenddt());
                    event.setPracexamstartdt(updatedEvent.getPracexamstartdt());
                    event.setPracpassdt(updatedEvent.getPracpassdt());
                    event.setPracregenddt(updatedEvent.getPracregenddt());
                    event.setPracregstartdt(updatedEvent.getPracregstartdt());
                    return api_eventRepository.save(event);
                })
                .orElseThrow(() -> new RuntimeException("Event Not Found"));
    }

    // DELETE
    public void deleteEvent(Integer id){
        api_eventRepository.deleteById(id);
    }
}
