package com.example.softlearning.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.softlearning.applicationcore.entity.courses.appservices.CoursesServices;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@RestController
@RequestMapping("/softlearning/courses")
public class RestCoursesController {
    @Autowired
    CoursesServices coursesServices;

        @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonCoursesByCode(@PathVariable(value = "code") Integer code) {
        try {
            return ResponseEntity.ok(coursesServices.getByCodeToJson(code));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    
    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getXmlCoursesByCode(@PathVariable(value = "code") Integer code) {
        try {
            return ResponseEntity.ok(coursesServices.getByCodeToXml(code));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newCoursesFromJson(@RequestBody String courses) {
        try {
            return ResponseEntity.ok(coursesServices.addFromJson(courses));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> newCoursesFromXml(@RequestBody String courses) {
        try {
            return ResponseEntity.ok(coursesServices.addFromXml(courses));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{code}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCoursesFromJson(@PathVariable(value = "code") Integer code,
    @RequestBody String courses) {
        try {
            return ResponseEntity.ok(coursesServices.updateOneFromJson(courses));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{code}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> updateCoursesFromXml(@PathVariable(value = "code") Integer code,
            @RequestBody String courses) {
        try {
            return ResponseEntity.ok(coursesServices.updateOneFromXml(courses));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteByCode(@PathVariable(value = "code") Integer code) {
        try {
            coursesServices.deleteByCode(code);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
