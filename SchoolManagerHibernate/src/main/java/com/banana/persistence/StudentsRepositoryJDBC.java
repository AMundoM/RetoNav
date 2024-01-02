package com.banana.persistence;

import com.banana.models.Student;
import com.banana.util.JPAUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Setter
@Getter
public class StudentsRepositoryJDBC implements StudentsRepositoryInf {

    private EntityManager entityManager;

    private String urlConn;

    public StudentsRepositoryJDBC() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void add(Student estudiante) {
        entityManager.getTransaction().begin();

        if (estudiante.isValid()) {
            entityManager.persist(estudiante);
            entityManager.getTransaction().commit();
        }

    }

    @Override
    public Student get(int idx) {
        TypedQuery<Student> q = entityManager.createQuery("SELECT s FROM Student s ORDER BY s.id", Student.class);
        q.setFirstResult(idx-1).setMaxResults(idx);
        List<Student> estudiantes = q.getResultList();
        System.out.println("estudiantes:"+estudiantes);
        return estudiantes != null && estudiantes.size() > 0 ? estudiantes.get(0) : null;
    }

    @Override
    public Student getById(Long id) {
        return entityManager.find(Student.class, id);
    }

}
