package com.lewiscode.unittest.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
public class StudentRepository {
    @Autowired
    private StudentRepo studentRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testGetStudentByName_returnsStudentDetails(){

        //given
       Student savedStudent = testEntityManager.persistFlushFind(new Student(null,"james"));
        //when
        Student student = studentRepository.getStudentByName("james");
        //then
        then(student.getId()).isNotNull();
        then(student.getName()).isEqualTo(savedStudent.getName());

    }

}
