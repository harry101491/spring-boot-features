package com.harshit.jpahibernate.repository;

import javax.persistence.EntityManager;

import com.harshit.jpahibernate.entity.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    EntityManager entityManager;

    /**
     * Find the Student by Id
     * @param id
     * @return
     */
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }
    
    /**
     * delete a Student row using an id.
     * @param id
     */
    public void deleteById(Long id) {
        Student Student = this.findById(id);
        entityManager.remove(Student);
    }

    /**
     * Save method performing update and insert.
     * @param Student Object to be updated or inserted
     * @return Student object returned
     */
    public Student save(Student Student) {
        if(Student.getId() == null) {
            entityManager.persist(Student);
        }
        else {
            entityManager.merge(Student);
        }
        return Student;
    }

    // public void saveStudentWithPassport() {
    //     Passport passport = new Passport("X879033");
    //     entityManager.persist(passport);

    //     Student student = new Student("Pareek");
    //     student.setPassport(passport);
    //     entityManager.persist(student);
    // }

    // public void findStudent() {
    //     Student student = findById(2001L);
    //     logger.info("Student is: -> {}", student.getName());
    //     logger.info("Passport is: -> {}", student.getPassport());
    // }

    // public void findPassport() {
    //     Passport passport = entityManager.find(Passport.class, 3001L);
    //     logger.info("Student is: -> {}", passport.getNumber());
    //     logger.info("Passport is: -> {}", passport.getStudent());
    // }
    // public void createJPQLQuery() {
    //     List<Student> Students = entityManager.createNamedQuery("query_find_all_Students", Student.class).getResultList();

    //     Students.stream().forEach(c -> this.logger.info("Student is: -> {}", c));

    //     List<Student> whereStudents = entityManager.createNamedQuery("query_find_name_like_computer", Student.class).getResultList();

    //     whereStudents.stream().forEach(c -> this.logger.info("Student with where clause: -> {}", c));
    // }

    // public void createNativeQuery() {
    //     List<Student> Students = entityManager.createNativeQuery("SELECT * FROM Student", Student.class).getResultList();

    //     Students.stream().forEach(c -> this.logger.info("Native Query Student is: -> {}", c));
    // }
}