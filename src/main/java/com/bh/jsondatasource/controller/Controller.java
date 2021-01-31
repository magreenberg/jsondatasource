package com.bh.jsondatasource.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "datasource")
public class Controller {
    @GetMapping("/")
    public void TestConnection() {
    }

    @PostMapping("/search")
    public ResponseEntity<Object>  search(@RequestBody Search search) {
        System.out.println("New search request " + search.toString());
        return new ResponseEntity<Object>("Search Result TBD", HttpStatus.OK);
    }

    @PostMapping("/query")
    public ResponseEntity<Object> query(@RequestBody Query query) throws Exception {
        System.out.println("New query request " + query.toString());
        return new ResponseEntity<Object>("Query Result TBD", HttpStatus.OK);
    }

    @PostMapping("/annotations")
    public ResponseEntity<Object> annotations(@RequestBody Annotations annotationRequest) {
        System.out.println("New annotation request " + annotationRequest.toString());
        return new ResponseEntity<Object>("Annotation Result TBD", HttpStatus.OK);
    }
}


