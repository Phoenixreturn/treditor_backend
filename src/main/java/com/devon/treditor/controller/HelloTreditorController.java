package com.devon.treditor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class HelloTreditorController implements HelloTreditorApi {
    @Override
    public ResponseEntity<String> makeHello() {
        return new ResponseEntity<>("hello treditor", HttpStatus.OK);
    }
}
