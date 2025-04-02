package com.StudyBuddy.calender.APIEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class API_Items {
    @JsonProperty("item")
    private List<API_Item> item;
}
