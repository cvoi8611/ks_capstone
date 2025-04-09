package com.StudyBuddy.calender.Controller;

import com.StudyBuddy.calender.APIEntity.API_FilteredItem;
import com.StudyBuddy.calender.APIEntity.API_Item;
import com.StudyBuddy.calender.APIEntity.API_Response;
import com.StudyBuddy.calender.Entity.API_Event;
import com.StudyBuddy.calender.Service.API_EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api_event")
public class API_EventRestController {

    @Autowired
    private API_EventService api_eventService;

    @Value("${service.key}")
    private String API_KEY;

    private final String API_URL = "http://openapi.q-net.or.kr/api/service/rest/InquiryTestInformationNTQSVC/";
    private final String PEList_URL = API_URL.concat("getPEList?ServiceKey="+API_KEY);
    private final String MCList_URL = API_URL.concat("getMCList?ServiceKey="+API_KEY);
    private final String EList_URL = API_URL.concat("getEList?ServiceKey="+API_KEY);
    private final String CList_URL = API_URL.concat("getCList?ServiceKey="+API_KEY);
    private final String FeeList_URL = API_URL.concat("getFeeList?ServiceKey="+API_KEY);
    private final String JMList_URL = API_URL.concat("getJMList?ServiceKey="+API_KEY);

    public List<API_Item> getEachItem(API_Response response){
        return response
                .getResponse()
                .getBody()
                .getItems()
                .getItem();
    }

    public List<API_FilteredItem> mergeDuplicatedItem(List<API_Item> items){
        Map<String, List<API_Item>> grouped = items.stream()
                .collect(Collectors.groupingBy(API_Item::getDescription));

        List<API_FilteredItem> result = new ArrayList<>();

        for (Map.Entry<String, List<API_Item>> entry : grouped.entrySet()) {
            String description = entry.getKey();
            List<API_Item> group = entry.getValue();

            API_Item representative = group.get(0);

            API_FilteredItem merged = new API_FilteredItem();
            merged.setDescription(description);
            merged.setDocexamdt(representative.getDocexamdt());
            merged.setDocpassdt(representative.getDocpassdt());
            merged.setDocsubmitstartdt(representative.getDocsubmitstartdt());
            merged.setDocsubmitentdt(representative.getDocsubmitentdt());
            merged.setPracexamstartdt(representative.getPracexamstartdt());
            merged.setPracexamenddt(representative.getPracexamenddt());
            merged.setPracpassdt(representative.getPracpassdt());

            for (API_Item item : group) {
                merged.getDocregstartdt().add(item.getDocregstartdt());
                merged.getDocregenddt().add(item.getDocregenddt());
                merged.getPracregstartdt().add(item.getPracregstartdt());
                merged.getPracregenddt().add(item.getPracregenddt());
            }
            result.add(merged);
        }
        return result;
    }

    public void printingItems(List<API_FilteredItem> filteredItems){
        for (API_FilteredItem item : filteredItems) {
            System.out.println("시험 명 : "+item.getDescription());
            System.out.println("필기 시험 시작일 : "+item.getDocexamdt());
            System.out.println("필기시험 합격 예정자 발표 : "+item.getDocpassdt());
            System.out.println("필기시험 접수 마감일 / 빈자리 접수 시작일 : "+item.getDocregstartdt());
            System.out.println("필기시험 접수 마감일 / 빈자리 접수 마감일 : "+item.getDocregenddt());
            System.out.println("응시자격 서류제출 / 필기시험 합격자 결정 시작일 : "+item.getDocsubmitstartdt());
            System.out.println("응시자격 서류제출 / 필기시험 합격자 결정 마감일 : "+item.getDocsubmitentdt());
            System.out.println("실기시험 시작일 : "+item.getPracexamstartdt());
            System.out.println("실기시험 마감일 : "+item.getPracexamenddt());
            System.out.println("합격자 발표일 : "+item.getPracpassdt());
            System.out.println("실기시험 원서 접수 시작일 : "+item.getPracregstartdt());
            System.out.println("실기시험 원서 접수 마감일 : "+item.getPracregenddt());
            System.out.println("/////////////////////////////////////////");
        }
    }

    public API_Response parseStringToApiResponse(String response){
        // ObjectMapper로 수동 파싱
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, API_Response.class);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "API 데이터 파싱 오류");
        }
    }

    public void saveEachItem(List<API_FilteredItem> filteredItems){
        for (API_FilteredItem item : filteredItems){
            API_Event event = API_Event.fromDto(item);
            api_eventService.saveApiEvent(event);
        }
    }

    /*
    // READ (GET)
    // getPEList
    @Value("${service.key}")
    private String API_KEY;

    @RequestMapping("/getPEList")
    public List<Map<String, Object>> getPEList() {
        RestTemplate restTemplate = new RestTemplate();

        // JSON 데이터를 Map으로 변환
        Map<String, Object> response = restTemplate.getForObject(API_URL, Map.class);

        // 필요한 데이터 추출
        Map<String, Object> body = (Map<String, Object>) response.get("body");
        Map<String, Object> items = (Map<String, Object>) body.get("items");
        return (List<Map<String, Object>>) items.get("item");
    }
    */
    @RequestMapping("/deleteAll")
    public void deleteAllEvents() {
        System.out.println("모든 데이터가 삭제되었습니다.");
        api_eventService.deleteAll();
    }

    /*
    //@RequestMapping
    @PostMapping("/create")
    public List<API_FilteredItem> createEvent(List<API_FilteredItem> event){
        List<API_FilteredItem> savedEvent = api_eventService.createEvent(event);
        return api_eventService.createEvent(savedEvent);
    }
    */

    // READ (GET)
    @RequestMapping("/readAll")
    public List<API_Event> getAllEvents() {
        return api_eventService.getAllEvents();
    }

    @RequestMapping("/read/{id}")
    public Optional<API_Event> getEventById(@PathVariable Integer id) {
        return api_eventService.getEventById(id);
    }

    @RequestMapping("/read/{description}")
    public List<API_Event> getEventByUserId(@PathVariable String description) {
        return api_eventService.getEventByDescription(description);
    }

    // UPDATE (PUT)
    @RequestMapping("/update/{id}")
    public API_Event updateEvent(@PathVariable Integer id, @RequestBody API_Event event) {
        return api_eventService.updateEvent(id, event);
    }

    // DELETE (DELETE)
    @RequestMapping("/delete/{id}")
    public void deleteEvent(@PathVariable Integer id) {
        api_eventService.deleteEvent(id);
    }




    @GetMapping("/getPEList")
    public List<API_FilteredItem> getPEList() {

        RestTemplate restTemplate = new RestTemplate();
        //String rawResponse = restTemplate.getForObject(PEList_URL, String.class);
        //System.out.println("Raw JSON Response: " + rawResponse);
        //API_Response apiResponse = parseStringToApiResponse(rawResponse);

        API_Response apiResponse = restTemplate.getForObject(PEList_URL, API_Response.class);
        List<API_Item> responseEachItem = getEachItem(Objects.requireNonNull(apiResponse));
        List<API_FilteredItem> FilteredItem = mergeDuplicatedItem(responseEachItem);

        // DB에 읽은 API 데이터 저장
        saveEachItem(FilteredItem);

        return FilteredItem;
    }

    @GetMapping("/getMCList")
    public List<API_FilteredItem> getMCList() {
        RestTemplate restTemplate = new RestTemplate();

        API_Response apiResponse = restTemplate.getForObject(MCList_URL, API_Response.class);
        List<API_Item> responseEachItem = getEachItem(Objects.requireNonNull(apiResponse));
        List<API_FilteredItem> FilteredItem = mergeDuplicatedItem(responseEachItem);

        // DB에 읽은 API 데이터 저장
        saveEachItem(FilteredItem);

        return FilteredItem;
    }

    @GetMapping("/getEList")
    public List<API_FilteredItem> getEList() {
        RestTemplate restTemplate = new RestTemplate();

        API_Response apiResponse = restTemplate.getForObject(EList_URL, API_Response.class);
        List<API_Item> responseEachItem = getEachItem(Objects.requireNonNull(apiResponse));
        List<API_FilteredItem> FilteredItem = mergeDuplicatedItem(responseEachItem);

        // DB에 읽은 API 데이터 저장
        saveEachItem(FilteredItem);

        return FilteredItem;
    }

    @GetMapping("/getCList")
    public List<API_FilteredItem> getCList() {
        RestTemplate restTemplate = new RestTemplate();

        API_Response apiResponse = restTemplate.getForObject(CList_URL, API_Response.class);
        List<API_Item> responseEachItem = getEachItem(Objects.requireNonNull(apiResponse));
        List<API_FilteredItem> FilteredItem = mergeDuplicatedItem(responseEachItem);

        // DB에 읽은 API 데이터 저장
        saveEachItem(FilteredItem);

        return FilteredItem;
    }

    @GetMapping("/getFeeList")
    public List<API_FilteredItem> getFeeList() {
        RestTemplate restTemplate = new RestTemplate();

        API_Response apiResponse = restTemplate.getForObject(FeeList_URL, API_Response.class);
        List<API_Item> responseEachItem = getEachItem(Objects.requireNonNull(apiResponse));
        List<API_FilteredItem> FilteredItem = mergeDuplicatedItem(responseEachItem);

        // DB에 읽은 API 데이터 저장
        saveEachItem(FilteredItem);

        return FilteredItem;
    }

    @GetMapping("/getJMList")
    public List<API_FilteredItem> getJMList() {
        RestTemplate restTemplate = new RestTemplate();

        API_Response apiResponse = restTemplate.getForObject(JMList_URL, API_Response.class);
        List<API_Item> responseEachItem = getEachItem(Objects.requireNonNull(apiResponse));
        List<API_FilteredItem> FilteredItem = mergeDuplicatedItem(responseEachItem);

        // DB에 읽은 API 데이터 저장
        saveEachItem(FilteredItem);

        return FilteredItem;
    }

}
