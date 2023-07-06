package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {

//	void findByTitle();
// @Query(value = "SELECT * FROM courseReg WHERE title=:courseTitle", nativeQuery=true )
	Course findByTitle(String courseTitle);
	
}
