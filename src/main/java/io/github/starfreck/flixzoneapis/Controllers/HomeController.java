package io.github.starfreck.flixzoneapis.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String Home(){
        return "Hi! Welcome to FlixZone";
    }

    @RequestMapping("/api")
    public String apiHome(){
        return "Hi! Welcome to FlixZone APIs";
    }

}
