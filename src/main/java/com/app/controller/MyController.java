package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Course;
import com.app.service.CourseService;


@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/home")
	public String home() {
		return "this is home page";
		}
	
	//get courses
	
	//@RequestMapping(path= "/courses", method= RequestMethod.GET)
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
////	@RequestMapping(path= "/courses/{courseId}", method= RequestMethod.GET)
//	@GetMapping("/courses/id/{courseId}")
//	public Course getCourse(@PathVariable String courseId) {
//		return this.courseService.getCourse(Long.parseLong(courseId));
//	}
//	
//	@GetMapping("/courses/title/{courseTitle}")
//    public Course getCourseByTitle(@PathVariable String courseTitle) {
//        Course course = courseService.getCourseByTitle(courseTitle);
//        if (course != null) {
//        	return course;
////            return ResponseEntity.ok(course);
//        } else {
//            System.out.println("Course not found with title: " + courseTitle);
//            return null;
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//        }
//    }
	
	@RequestMapping(path= "/courses/courseId/{courseId}", method= RequestMethod.GET)
//	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@GetMapping("/courses/courseTitle/{courseTitle}")
    public Course getCourseByTitle(@PathVariable String courseTitle) {
        Course course = courseService.getCourseByTitle(courseTitle);
        if (course != null) {
        	return course;
//            return ResponseEntity.ok(course);
        } else {
            System.out.println("Course not found with title: " + courseTitle);
            return null;
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
	
	
	
	
	
	//@RequestMapping(path= "/courses", method= RequestMethod.POST)
	@PostMapping(path="/courses", consumes ="application/json")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@PathVariable long courseId, @RequestBody Course course) {
	    return this.courseService.updateCourse(courseId, course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleatCourse(@PathVariable String courseId) {
		try {

			this.courseService.deleatCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
