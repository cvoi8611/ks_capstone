package com.StudyBuddy.calender.APIEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class API_Response {
    @JsonProperty("response")
    private API_ResponedData response;

}
