package com.lewiscode.unittest.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    public Student getStudentById(Long id) {

        Optional<Student> student = studentRepo.findById(id);
        return student.orElseThrow(StudentNotFoundException::new);

    }
}
