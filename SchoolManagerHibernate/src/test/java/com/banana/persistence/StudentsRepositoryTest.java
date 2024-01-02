package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
//@ActiveProfiles("dev")
class
StudentsRepositoryTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private StudentsRepositoryInf repoStudents;

    @Test
    void testBeans() {
        assertNotNull(context);
        assertNotNull(repoStudents);
    }

    @Test
    void add() {
        Student newStd = new Student(null, "Juan", "Juanez", 2);
        System.out.println(newStd);
        repoStudents.add(newStd);
        assertNotNull(newStd);
        assertTrue(newStd.getId() > 0);
    }

    @Test
    void getById() {
        Student aStudent = repoStudents.getById(1L);
        System.out.println(aStudent);
        assertNotNull(aStudent);
    }


    @Test
    void get() {
        Student aStudent = repoStudents.get(2);
        System.out.println(aStudent);
        assertNotNull(aStudent);
    }
}