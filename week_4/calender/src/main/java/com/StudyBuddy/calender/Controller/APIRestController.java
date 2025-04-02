package com.StudyBuddy.calender.Controller;

import com.StudyBuddy.calender.APIEntity.API_Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/event")
public class APIRestController {

    @Value("${service.key}")
    private String API_KEY;

    private final String API_URL = "http://openapi.q-net.or.kr/api/service/rest/InquiryTestInformationNTQSVC/";
    private final String PEList_URL = API_URL.concat("getPEList?ServiceKey="+API_KEY);
    private final String MCList_URL = API_URL.concat("getMCList?ServiceKey="+API_KEY);
    private final String EList_URL = API_URL.concat("getEList?ServiceKey="+API_KEY);
    private final String CList_URL = API_URL.concat("getCList?ServiceKey="+API_KEY);
    private final String FeeList_URL = API_URL.concat("getFeeList?ServiceKey="+API_KEY);
    private final String JMList_URL = API_URL.concat("getJMList?ServiceKey="+API_KEY);

    @GetMapping("/getPEList")
    public API_Response getPEList() {
        RestTemplate restTemplate = new RestTemplate();
        String rawResponse = restTemplate.getForObject(PEList_URL, String.class);
        System.out.println("Raw JSON Response: " + rawResponse);


        return restTemplate.getForObject(PEList_URL, API_Response.class);
    }

    @GetMapping("/getMCList")
    public API_Response getMCList() {
        RestTemplate restTemplate = new RestTemplate();
        String rawResponse = restTemplate.getForObject(MCList_URL, String.class);
        System.out.println("Raw JSON Response: " + rawResponse);


        return restTemplate.getForObject(MCList_URL, API_Response.class);
    }

    @GetMapping("/getEList")
    public API_Response getEList() {
        RestTemplate restTemplate = new RestTemplate();
        String rawResponse = restTemplate.getForObject(EList_URL, String.class);
        System.out.println("Raw JSON Response: " + rawResponse);


        return restTemplate.getForObject(EList_URL, API_Response.class);
    }

    @GetMapping("/getCList")
    public API_Response getCList() {
        RestTemplate restTemplate = new RestTemplate();
        String rawResponse = restTemplate.getForObject(CList_URL, String.class);
        System.out.println("Raw JSON Response: " + rawResponse);


        return restTemplate.getForObject(CList_URL, API_Response.class);
    }

    @GetMapping("/getFeeList")
    public API_Response getFeeList() {
        RestTemplate restTemplate = new RestTemplate();
        String rawResponse = restTemplate.getForObject(FeeList_URL, String.class);
        System.out.println("Raw JSON Response: " + rawResponse);


        return restTemplate.getForObject(FeeList_URL, API_Response.class);
    }

    @GetMapping("/getJMList")
    public API_Response getJMList() {
        RestTemplate restTemplate = new RestTemplate();
        String rawResponse = restTemplate.getForObject(JMList_URL, String.class);
        System.out.println("Raw JSON Response: " + rawResponse);


        return restTemplate.getForObject(JMList_URL, API_Response.class);
    }
}