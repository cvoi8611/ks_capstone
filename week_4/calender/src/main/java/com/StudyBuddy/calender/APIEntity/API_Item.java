package com.StudyBuddy.calender.APIEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class API_Item {
    @JsonProperty("description")
    private String description;

    @JsonProperty("docexamdt")
    private String docexamdt;

    @JsonProperty("docpassdt")
    private String docpassdt;

    @JsonProperty("docregenddt")
    private String docregenddt;

    @JsonProperty("docregstartdt")
    private String docregstartdt;

    @JsonProperty("docsubmitentdt")
    private String docsubmitentdt;

    @JsonProperty("docsubmitstartdt")
    private String docsubmitstartdt;

    @JsonProperty("pracexamenddt")
    private String pracexamenddt;

    @JsonProperty("pracexamstartdt")
    private String pracexamstartdt;

    @JsonProperty("pracpassdt")
    private String pracpassdt;

    @JsonProperty("pracregenddt")
    private String pracregenddt;

    @JsonProperty("pracregstartdt")
    private String pracregstartdt;
}
