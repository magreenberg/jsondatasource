package com.bh.jsondatasource.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bh.jsondatasource.api.User;
import com.bh.jsondatasource.services.ApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/datasource")
public class Controller {
    @Autowired
    private ApiService apiService;

    @GetMapping("")
    public ResponseEntity<String> TestConnection() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/getusers")
    public ResponseEntity<JsonNode> getUsers() {
        System.out.println("New getUsers request");
        //return new ResponseEntity<>("Hello World!", HttpStatus.OK);
        ResponseEntity<JsonNode> reo = ResponseEntity.ok(getJsonNode("[ {\"user_name\":\"fred\" }, { \"user_name\":\"barney\" }, { \"user_name\":\"betty\" }, { \"user_name\":\"barney\" }, { \"user_name\":\"wilma\" }, { \"user_name\":\"fred\" }, { \"user_name\":\"fred\" }, { \"user_name\":\"fred\" }, { \"user_name\":\"bambam\" } ]"));
        System.out.println("reo=" + reo);
        return reo;
    }

    @PostMapping("/search")
    public ResponseEntity<Object>  search(@RequestBody Search search) {
        System.out.println("New search request " + search.toString());
        return new ResponseEntity<Object>("Search Result TBD", HttpStatus.OK);
    }

    @PostMapping("/query")
    public ResponseEntity<JsonNode> query(@RequestBody Query query) throws Exception {
        System.out.println("New query request " + query.toString());
        List<User> users = apiService.getUsers();
        Map<String, Long> userCount = users.stream()
                .collect(Collectors.groupingBy(User::getUser_name, Collectors.counting()));
        StringBuilder resp = new StringBuilder("[ { \"columns\":[ {\"text\":\"Name\",\"type\":\"string\"}," +
            "{\"text\":\"Number\",\"type\":\"number\"} ]," +
            "\"rows\":[ ");
        // add names and counts to make "[\"bill\",1], [\"fred\",5], [\"john\",10], [\"Mary\",20]" 
        Iterator<Map.Entry<String, Long>> it = userCount.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> pair = it.next();
            resp.append("[\"" + pair.getKey() + "\"," + pair.getValue() + "]");
            if (it.hasNext()) {
                resp.append(",");
            }
        }
        resp.append(" ] } ]");
        System.out.println(resp.toString());


        ResponseEntity<JsonNode> reo = ResponseEntity.ok(getJsonNode(resp.toString()));
        // long seconds = System.currentTimeMillis();
        // ResponseEntity<JsonNode> reo = ResponseEntity.ok(getJsonNode("[ {
        // \"columns\":[ {\"text\":\"Time\",\"type\":\"time\"},
        // {\"text\":\"Country\",\"type\":\"string\"},
        // {\"text\":\"Number\",\"type\":\"number\"} ], \"rows\":[ [1234567,\"SE\",123],
        // [1234567,\"DE\",231], [1234567,\"US\",321] ], \"type\":\"table\" } ]"));
        // ResponseEntity<JsonNode> reo = ResponseEntity.ok(getJsonNode("[ {
        // \"columns\":[ {\"text\":\"Time\",\"type\":\"time\"},
        // {\"text\":\"Country\",\"type\":\"string\"},
        // {\"text\":\"Number\",\"type\":\"number\"} ], \"rows\":[ [" + seconds +
        // ",\"SE\",123], [" + seconds + ",\"DE\",231], [" + seconds + ",\"US\",321] ] }
        // ]"));
        // ResponseEntity<JsonNode> reo = ResponseEntity.ok(getJsonNode("[ {
        // \"columns\":[ {\"text\":\"Time\",\"type\":\"time\"},
        // {\"text\":\"tweet_contents.tags\",\"type\":\"string\"},
        // {\"text\":\"Number\",\"type\":\"number\"} ], \"rows\":[ [" + seconds +
        // ",\"SE\",1], [" + seconds + ",\"DE\",1], [" + seconds + ",\"US\",1] ] } ]"));
        // ResponseEntity<JsonNode> reo = ResponseEntity.ok(getJsonNode("[ {
        // \"columns\":[ {\"text\":\"Time\",\"type\":\"time\"},
        // {\"text\":\"tweet_contents.tags\",\"type\":\"string\"} ], \"rows\":[ [" +
        // seconds + ",\"SE\"], [" + seconds + ",\"DE\"], [" + seconds + ",\"US\"] ] }
        // ]"));
        // FAIL ResponseEntity<JsonNode> reo = ResponseEntity.ok(getJsonNode("[ {
        // \"user\":\"fred\",\"count\":\"2\"},{ \"user\":\"bill\",\"count\":\"4\"},{
        // \"user\":\"barney\",\"count\":\"4\"} ]"));
        // OK ResponseEntity<JsonNode> reo = ResponseEntity.ok(getJsonNode("[ {
        // \"columns\":[ {\"text\":\"tweet_contents.tags\",\"type\":\"string\"},
        // {\"text\":\"Number\",\"type\":\"number\"} ], \"rows\":[ [\"bill\",1],
        // [\"fred\",5], [\"john\",10] ] } ]"));
        // ResponseEntity<JsonNode> reo = ResponseEntity.ok(getJsonNode("[ {
        // \"columns\":[ {\"text\":\"Name\",\"type\":\"string\"},
        // {\"text\":\"Number\",\"type\":\"number\"} ], \"rows\":[ [\"bill\",1],
        // [\"fred\",5], [\"john\",10], [\"Mary\",20] ] } ]"));
        System.out.println("reo=" + reo);
        return reo;
    }

    @PostMapping("/annotations")
    public ResponseEntity<Object> annotations(@RequestBody Annotations annotationRequest) {
        System.out.println("New annotation request " + annotationRequest.toString());
        return new ResponseEntity<Object>("Annotation Result TBD", HttpStatus.OK);
    }

    private JsonNode getJsonNode(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree(jsonString);
            return json;
        } catch (JsonProcessingException jpe) {
            System.out.println("Failed to convert string to JSON:" + jpe.getMessage());
            return null;
        }
    }
}


