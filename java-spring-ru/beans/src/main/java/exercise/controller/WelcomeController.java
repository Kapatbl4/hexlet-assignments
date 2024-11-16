package exercise.controller;

import exercise.Application;
import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
@RestController
public class WelcomeController {
    @Autowired
    private Daytime daytime = Application.getDayTime();

    @GetMapping(path = "/welcome")
    public String greeting() {
        return "It is " + daytime.getName() + " now! Welcome to Spring!";
    }
}
// END
