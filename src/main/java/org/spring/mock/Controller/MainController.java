package org.spring.mock.Controller;

import jakarta.annotation.PostConstruct;
import org.spring.mock.Model.Person;
import org.spring.mock.Model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class MainController {

    private String answerJson;

    @PostConstruct
    public void init() throws IOException {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("answer.json"))) {
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        answerJson = sb.toString();
    }

    @GetMapping("/getMapping")
    public String getMapping() {
        return "get mapping - Hello";
    }

    @PostMapping("/postMapping")
    public String postMapping(@RequestBody String body) {
        System.out.println(body);
        return "Post Mapping";
    }

    @PostMapping("/postPerson")
    public Student changePerson(@RequestBody Person person) {
        Student student = new Student();
        student.setFullname(person.getName() + " " + person.getSurname());
        student.setYearGraduated(person.getAge() + 21);
        return student;
    }

    @PostMapping("/postPersonJsonReader")
    public String changePersonJsonReader(@RequestBody Person person) {
        return String.format(answerJson, person.getName(), person.getSurname(), person.getAge());
    }

    @GetMapping("/getWithParams")
    public String answer(@RequestParam("name")String name, @RequestParam("surname") String surname) {
        return name + " " + surname;
    }

    @GetMapping("/getWithAuth")
    public String answerWithAuth(
            @RequestParam("name")String name,
            @RequestParam("surname") String surname,
            @RequestHeader("Authorization")String jwt
    ) {
        return jwt;
    }

    @GetMapping("/getWithId/{pathVariable}/getUser")
    public String answerWithId(@PathVariable("pathVariable") String pathVar) {
        return pathVar;
    }

    @GetMapping("/getMappingReturnOk")
    public ResponseEntity<Student> answerOk() {
        return ResponseEntity.ok(new Student());
    }

    @GetMapping("/getMappingStatus")
    public ResponseEntity<String> answerStatus() {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Server is not OK");
    }
}
