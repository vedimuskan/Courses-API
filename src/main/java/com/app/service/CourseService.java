package com.app.service;

import java.util.List;

import com.app.entity.Course;


public interface CourseService {

	List<Course> getCourses();
	Course getCourse(long courseId);
	Course addCourse(Course course);
	Course updateCourse(long courseId, Course course);
	void deleatCourse(long courseId);
	Course getCourseByTitle(String courseTitle);
	
}
