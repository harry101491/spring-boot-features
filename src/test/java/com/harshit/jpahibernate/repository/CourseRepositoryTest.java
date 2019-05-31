package com.harshit.jpahibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.harshit.jpahibernate.JpaHibernateApplication;
import com.harshit.jpahibernate.entity.Course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class CourseRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String TEST_COURSE_NAME = "Microservices in 10 steps";

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void testShouldGetExpectedValueForCourseFindById() {
        Course course = courseRepository.findById(1001L);
        assertEquals("Computer Science 101", course.getName());
    }

    /**
     * Dirties Context will maintain the state of database before and
     * after the unit test run.
     */
    @Test
    @DirtiesContext
    public void testShouldGetExpectedValueForCourseDeleteById() {
        courseRepository.deleteById(1003L);
        assertNull(courseRepository.findById(1003L));
    }

    @Test
    @DirtiesContext
    public void testShouldGetExpectedValueForCourseSave() {
        // inserting a new 
        Course testCourse = this.courseRepository.save(new Course(TEST_COURSE_NAME));
        assertEquals(TEST_COURSE_NAME, this.courseRepository.findById(testCourse.getId()).getName());

        // updating the current course
        Course course = this.courseRepository.findById(1002L);
        course.setName(TEST_COURSE_NAME);

        Course updatedCourse = this.courseRepository.save(course);
        assertEquals(TEST_COURSE_NAME, updatedCourse.getName());
    }
}   
