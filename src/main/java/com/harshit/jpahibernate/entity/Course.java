package com.harshit.jpahibernate.entity;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "COURSE")
@NamedQueries(value = {
    @NamedQuery(name = "query_find_all_courses", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "query_find_name_like_computer", query = "SELECT c FROM Course c WHERE name LIKE '%Computer%'")
})
public class Course {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "last_updated_date")
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<Reviews> reviews;

    // required by hibernate
    protected Course() {}

    public Course(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + "]";
    }
    
}