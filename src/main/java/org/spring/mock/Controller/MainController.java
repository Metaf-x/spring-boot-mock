package org.spring.mock.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class MainController {
    @GetMapping("/getMapping")
    public String getMapping() {
        return "get mapping - Hello";
    }

    @PostMapping("/postMapping")
    public String postMapping(@RequestBody String body) {
        System.out.println(body);
        return "Post Mapping";
    }
}
