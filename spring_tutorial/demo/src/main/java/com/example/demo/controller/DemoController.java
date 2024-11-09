package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @GetMapping
    public void demo() {
        System.out.println("Hello World");
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping(value = "/test1")
    public ResponseEntity<String> test1(@RequestParam("name") String name) {
        String message = "Hello" + " " + name + "!";
        return ResponseEntity.ok(message);
    }

    @PostMapping(value = "/test2")
    public ResponseEntity<String> test2(@RequestBody String name) {
        String message = "Hello" + " " + name + "!";
        return ResponseEntity.ok(message);
    }

}
