package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

// import jakarta.persistence.EntityManager;
//import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Course;
import com.app.dao.CourseDao;


@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
//		list.add(new Course(145,"Java Core Course", "this course contains basics of JAVA"));
//		list.add(new Course(4343, "Spring Boot Course", "creating new springboot project"));
	}

	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
//		return list;
	}
	
	@Override
	public Course getCourse(long courseId) {
	    return courseDao.findById(courseId).orElse(null);
	}

	
	@Override
	public Course getCourseByTitle(String courseTitle) {
	    return courseDao.findByTitle(courseTitle);
	}
	
	
	
	

//	@Override
//	public Course getCourse(long courseId) {
//		
//		Course c= null;
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		} 
//		
////		return courseDao.findById(courseId);
//		
////		courseDao.findByTitle(course);
//		return c;
//	}

	@Override
	public Course addCourse(Course course) {
		try {
			list.add(course);
			courseDao.save(course);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return course;
	}
	
	@Override
	public Course updateCourse(long courseId, Course course) {
	    Course existingCourse = courseDao.findById(courseId).orElse(null);
	    if (existingCourse != null) {
	        existingCourse.setTitle(course.getTitle());
	        existingCourse.setDescription(course.getDescription());
	        courseDao.save(existingCourse);
	    }
	    return existingCourse;
	}


//	@Override
//	public Course updateCourse(long courseId, Course course) {
//		
//		for(Course c:list) {
//			if(c.getId()==courseId) {
//				c.setTitle(course.getTitle());
//				c.setDescription(course.getDescription());
//				break;
//			}
//		}
//		
////		courseDao.save(course);
//		
//		return course;
//	}

	
	@Override
	public void deleatCourse(long courseId) {
	    Course existingCourse = courseDao.findById(courseId).orElse(null);
	    if (existingCourse != null) {
	        list = list.stream().filter(course -> course.getId() != courseId).collect(Collectors.toList());
	        courseDao.delete(existingCourse);
	    }
	}

	
	
//	@Override
//	public void deleatCourse(long courseId) {
//		list= this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
////		Course entity= courseDao.getOne(courseId);
////		courseDao.deleteById(courseId);
//	}
	
	
	


}
