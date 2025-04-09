package com.StudyBuddy.calender.APIEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class API_FilteredItem {
    private String description;
    private String docexamdt;
    private String docpassdt;
    private String docsubmitstartdt;
    private String docsubmitentdt;
    private String pracexamstartdt;
    private String pracexamenddt;
    private String pracpassdt;

    private Set<String> docregstartdt = new HashSet<>();
    private Set<String> docregenddt = new HashSet<>();
    private Set<String> pracregstartdt = new HashSet<>();
    private Set<String> pracregenddt = new HashSet<>();
}
