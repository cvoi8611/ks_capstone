package com.StudyBuddy.calender.APIEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class API_ResponedData {
    @JsonProperty("header")
    private API_Header header;

    @JsonProperty("body")
    private API_Body body;
}
