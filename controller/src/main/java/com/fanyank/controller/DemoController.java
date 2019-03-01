package com.fanyank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/demo/layim")
    public String layim() {
        return "demo/layim";
    }
}
