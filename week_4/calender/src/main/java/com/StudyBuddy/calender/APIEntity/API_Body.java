package com.StudyBuddy.calender.APIEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class API_Body {
    @JsonProperty("items")
    private API_Items items;
}