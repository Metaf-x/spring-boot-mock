package org.spring.mock.Controller;

import org.apache.catalina.loader.ResourceEntry;
import org.spring.mock.Model.Person;
import org.spring.mock.Model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/postPerson")
    public Student changePerson(@RequestBody Person person) {
        Student student = new Student();
        student.setFullname(person.getName() + " " + person.getSurname());
        student.setYearGraduated(person.getAge() + 21);
        return student;
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
