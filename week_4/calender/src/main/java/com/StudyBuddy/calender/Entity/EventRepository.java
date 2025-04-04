package com.StudyBuddy.calender.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findEventByUserId(Integer user_id);
}