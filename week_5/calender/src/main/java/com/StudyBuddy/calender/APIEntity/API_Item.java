package com.StudyBuddy.calender.APIEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class API_Item {
    // 시험 명
    @JsonProperty("description")
    private String description;

    // 필기 시험 시작일
    @JsonProperty("docexamdt")
    private String docexamdt;

    // 필기 합격자 발표일
    @JsonProperty("docpassdt")
    private String docpassdt;

    // 필기 접수 마감일 / 필기 접수 빈자리 마감일
    @JsonProperty("docregenddt")
    private String docregenddt;

    // 필기 접수 시작일 / 필기 접수 빈자리 시작일
    @JsonProperty("docregstartdt")
    private String docregstartdt;

    // 응시자격 서류제출 / 필기시험 합격자 결정 마감일 (nullable)
    @JsonProperty("docsubmitentdt")
    private String docsubmitentdt;

    // 응시자격 서류제출 / 필기시험 합격자 결정 시작일 (nullable)
    @JsonProperty("docsubmitstartdt")
    private String docsubmitstartdt;

    // 실기 시험 마감일
    @JsonProperty("pracexamenddt")
    private String pracexamenddt;

    // 실기 시험 시작일
    @JsonProperty("pracexamstartdt")
    private String pracexamstartdt;

    // 실기 합격자 발표일
    @JsonProperty("pracpassdt")
    private String pracpassdt;

    // 실기 접수 마감일
    @JsonProperty("pracregenddt")
    private String pracregenddt;

    // 실기 접수 시작일
    @JsonProperty("pracregstartdt")
    private String pracregstartdt;
}
