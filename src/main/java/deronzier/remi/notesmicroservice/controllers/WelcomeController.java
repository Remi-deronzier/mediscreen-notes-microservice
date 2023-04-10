package deronzier.remi.notesmicroservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is the controller class to welcome a user at /
 * 
 * @author Rémi Deronzier
 */
@RestController
@RequestMapping("/")
public class WelcomeController {

    @Value("${label.welcome}")
    private String greetings;

    /**
     * @return String
     */
    @GetMapping
    public String getWelcomeMessage() {
        return greetings;
    }
}
