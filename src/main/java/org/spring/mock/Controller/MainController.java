package org.spring.mock.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MainController {
    @GetMapping("/getMapping")
    public String getMapping() {
        return "get mapping - Hello";
    }

}
