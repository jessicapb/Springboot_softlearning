package com.example.softlearning.presentation.api.rest;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.softlearning.applicationcore.entity.book.appservices.BookServices;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;


@RestController
@RequestMapping("/softlearning/books")
public class RestBookController {
    @Autowired
    BookServices bookServices;

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonBookByCode(@PathVariable(value = "code") Integer code) {
        try {
            return ResponseEntity.ok(bookServices.getByCodeToJson(code));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    
    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getXmlBookByCode(@PathVariable(value = "code") Integer code) {
        try {
            return ResponseEntity.ok(bookServices.getByCodeToXml(code));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newBookFromJson(@RequestBody String book) {
        try {
            return ResponseEntity.ok(bookServices.addFromJson(book));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> newBookFromXml(@RequestBody String book) {
        try {
            return ResponseEntity.ok(bookServices.addFromXml(book));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{code}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateBookFromJson(@PathVariable(value = "code") Integer code,
    @RequestBody String book) {
        try {
            return ResponseEntity.ok(bookServices.updateOneFromJson(book));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{code}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> updateBookFromXml(@PathVariable(value = "code") Integer code,
            @RequestBody String book) {
        try {
            return ResponseEntity.ok(bookServices.updateOneFromXml(book));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteByCode(@PathVariable(value = "code") Integer code) {
        try {
            bookServices.deleteByCode(code);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
