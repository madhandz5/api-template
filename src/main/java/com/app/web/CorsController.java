package com.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CorsController {

    @GetMapping(value = "/cors")
    public String cors() {
        return "cors";
    }

}
