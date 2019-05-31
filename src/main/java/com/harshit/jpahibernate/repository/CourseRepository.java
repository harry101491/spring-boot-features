package com.harshit.jpahibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.harshit.jpahibernate.entity.Course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    EntityManager entityManager;

    /**
     * Find the course by Id
     * @param id
     * @return
     */
    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }
    
    /**
     * delete a course row using an id.
     * @param id
     */
    public void deleteById(Long id) {
        Course course = this.findById(id);
        entityManager.remove(course);
    }

    /**
     * Save method performing update and insert.
     * @param course Object to be updated or inserted
     * @return course object returned
     */
    public Course save(Course course) {
        if(course.getId() == null) {
            entityManager.persist(course);
        }
        else {
            entityManager.merge(course);
        }
        return course;
    }

    public void createJPQLQuery() {
        List<Course> courses = entityManager.createNamedQuery("query_find_all_courses", Course.class).getResultList();

        courses.stream().forEach(c -> this.logger.info("Course is: -> {}", c));

        List<Course> whereCourses = entityManager.createNamedQuery("query_find_name_like_computer", Course.class).getResultList();

        whereCourses.stream().forEach(c -> this.logger.info("Course with where clause: -> {}", c));
    }

    public void createNativeQuery() {
        List<Course> courses = entityManager.createNativeQuery("SELECT * FROM Course", Course.class).getResultList();

        courses.stream().forEach(c -> this.logger.info("Native Query Course is: -> {}", c));
    }
}