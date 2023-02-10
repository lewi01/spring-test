package com.lewiscode.unittest.integration;

import jakarta.transaction.Transactional;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class StudentServiceTest {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentService studentService;
    @Test
    void getStudentById_forSavedStudent_isReturned(){

        //given
        Student savedStudent = studentRepo.save(new Student(null,"lewis"));
        //when
        Student student =studentService.getStudentById(savedStudent.getId());
        //then
        then(student.getName()).isEqualTo("lewis");
        then(student.getId()).isNotNull();

    }
    @Test
    void getStudentById_whenMissingStudent_notFoundExceptionThrown(){
        //given
        Long id = 123l;
        //when
        Throwable throwable = catchThrowable(()->studentService.getStudentById(id));
        //then
        BDDAssertions.then(throwable).isInstanceOf(StudentNotFoundException.class);

    }

}
