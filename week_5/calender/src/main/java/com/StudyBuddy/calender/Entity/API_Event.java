package com.StudyBuddy.calender.Entity;

import com.StudyBuddy.calender.APIEntity.API_FilteredItem;
import com.StudyBuddy.calender.Converter.StringSetConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "API_event")
public class API_Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String description;

    // 필기 시험 시작일
    @Column(length = 100)
    private String docexamdt;

    // 필기 합격자 발표일
    @Column(length = 100)
    private String docpassdt;

    // 필기 접수 마감일 / 필기 접수 빈자리 마감일
    @Column(length = 100)
    private String docregenddt;

    // 필기 접수 시작일 / 필기 접수 빈자리 시작일
    @Column(length = 100)
    private String docregstartdt;

    // 응시자격 서류제출 / 필기시험 합격자 결정 마감일 (nullable)
    @Column(length = 100, nullable = true)
    private String docsubmitentdt;

    // 응시자격 서류제출 / 필기시험 합격자 결정 시작일 (nullable)
    @Column(length = 100, nullable = true)
    private String docsubmitstartdt;

    // 실기 시험 마감일
    @Column(length = 100)
    private String pracexamenddt;

    // 실기 시험 시작일
    @Column(length = 100)
    private String pracexamstartdt;

    // 실기 합격자 발표일
    @Column(length = 100)
    private String pracpassdt;

    // 실기 접수 마감일
    @Column(length = 100)
    private String pracregenddt;

    // 실기 접수 시작일
    @Column(length = 100)
    private String pracregstartdt;

    // 정적 변환 메서드
    public static API_Event fromDto(API_FilteredItem dto) {
        API_Event event = new API_Event();
        event.setDescription(dto.getDescription());
        event.setDocexamdt(dto.getDocexamdt());
        event.setDocpassdt(dto.getDocpassdt());
        event.setDocsubmitstartdt(dto.getDocsubmitstartdt());
        event.setDocsubmitentdt(dto.getDocsubmitentdt());
        event.setPracexamstartdt(dto.getPracexamstartdt());
        event.setPracexamenddt(dto.getPracexamenddt());
        event.setPracpassdt(dto.getPracpassdt());
        event.setDocregstartdt(String.join(",", dto.getDocregstartdt()));
        event.setDocregenddt(String.join(",", dto.getDocregenddt()));
        event.setPracregstartdt(String.join(",", dto.getPracregstartdt()));
        event.setPracregenddt(String.join(",", dto.getPracregenddt()));
        return event;
    }
}
