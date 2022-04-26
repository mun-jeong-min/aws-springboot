package com.example.aws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stop")
public class Controller {
    @GetMapping("/as")
    public String get() {
        return "liverpool";
    }

    @GetMapping("/aa")
    public String post() {
        return "Moon";
    }
}
