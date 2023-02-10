package com.lewiscode.unittest.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/student/{id}")
    Student getStudent(@PathVariable Long id){
        return  studentService.getStudentById(id);
    }
}
