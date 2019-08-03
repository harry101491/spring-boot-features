package com.harshit.jpahibernate;

// import java.util.List;

import javax.transaction.Transactional;

import com.harshit.jpahibernate.entity.User;
// import com.harshit.jpahibernate.model.SearchCriteria;
// import com.harshit.jpahibernate.model.specifications.UserSpecification;
import com.harshit.jpahibernate.repository.UserRepository;

import org.junit.Before;
// import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class JpaSpecificationTest {
   
    @Autowired()
    UserRepository userRepository;

    private User userJohn;
    private User userTom;

    @Before()
    public void init() {
        userJohn = new User();
        userJohn.setFirstName("John");
        userJohn.setLastName("Doe");
        userJohn.setAge(22);
        userRepository.save(userJohn);
 
        userTom = new User();
        userTom.setFirstName("Tom");
        userTom.setLastName("Doe");
        userTom.setAge(26);
        userRepository.save(userTom);
    }


    // @Test()
    // public void givenLast_whenGettingListOfUsers_thenCorrect() {
    //     UserSpecification spec = 
    //     new UserSpecification(new SearchCriteria("lastName", ":", "doe"));
        
    //     List<User> results = userRepository.findAll(spec);
    
    //     assertThat(userJohn, IsIn(results));
    //     assertThat(userTom, IsIn(results));
    // }
}