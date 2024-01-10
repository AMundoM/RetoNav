package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.School;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@ActiveProfiles("dev")
class SchoolsRepositoryInfTest {

    @Autowired
    private SchoolsRepositoryInf repo;

    /*@Test
    void testBeans(){
        assertNotNull(repo);
    }*/

    @Test
    void add() {
        School sch = new School(null, "Mi escuela", null);
        repo.add(sch);
        assertNotNull(sch);
        assertTrue(sch.getId() > 0);
    }

    @Test
    void update() {
        School sch = new School(1L, "Mi escuela cambio", null);
        School schC = repo.update(sch);
        assertNotNull(sch);
        assertEquals(sch.getName(), schC.getName());
    }

    @Test
    void getById() {
        School sch = repo.getById(1L);
        assertNotNull(sch);
    }
}