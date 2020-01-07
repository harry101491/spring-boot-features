package com.harshit.jpahibernate;

import com.harshit.jpahibernate.entity.City;
import com.harshit.jpahibernate.mybatis.mapper.CityMapper;
import com.harshit.jpahibernate.repository.CourseRepository;
import com.harshit.jpahibernate.repository.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Autowired
	// CourseRepository courseRepository;

	// @Autowired
	// StudentRepository studentRepository;

	@Autowired
	CityMapper cityMapper;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		City city = (City)cityMapper.findByState("Rajasthan");
		this.logger.info("The value of city is: {}", city);
		// studentRepository.saveStudentWithPassport();
		// studentRepository.findStudent();
		// studentRepository.findPassport();
		// Course course = this.courseRepository.findById(1001L);
		// this.logger.info("Course found by {} is {}", 1001L, course);

		// this.courseRepository.deleteById(1002L);
		// this.courseRepository.save(new Course("Node Complete Guide"));

		// this.courseRepository.createJPQLQuery();
		// this.courseRepository.createNativeQuery();
	}	

}
