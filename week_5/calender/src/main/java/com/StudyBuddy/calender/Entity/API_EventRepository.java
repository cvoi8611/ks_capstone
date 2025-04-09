package com.StudyBuddy.calender.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface API_EventRepository extends JpaRepository<API_Event, Integer> {
    List<API_Event> findAPIEventByDescription(String description);
}