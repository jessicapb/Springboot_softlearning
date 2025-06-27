package com.example.softlearning.presentation.api.rest;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.softlearning.applicationcore.entity.employee.appservices.EmployeeServices;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/softlearning/employee")
public class RestEmployeeController {
    @Autowired
    EmployeeServices employeeServices;

    @GetMapping(value = "/{ident}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonEmployeeByIdent(@PathVariable(value = "ident") Integer ident) {
        try {
            return ResponseEntity.ok(employeeServices.getByIdentToJson(ident));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping(value = "/{ident}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getXmlEmployeeByIdent(@PathVariable(value = "ident") Integer ident) {
        try {
            return ResponseEntity.ok(employeeServices.getByIdentToXml(ident));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newEmployeeFromJson(@RequestBody String employee) {
        try {
            return ResponseEntity.ok(employeeServices.addFromJson(employee));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> newEmployeeFromXml(@RequestBody String employee) {
        try {
            return ResponseEntity.ok(employeeServices.addFromXml(employee));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{ident}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateEmployeeFromJson(@PathVariable(value = "ident") Integer ident,
    @RequestBody String employee) {
        try {
            return ResponseEntity.ok(employeeServices.updateOneFromJson(employee));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{ident}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> updateEmployeeFromXml(@PathVariable(value = "ident") Integer ident,
    @RequestBody String employee) {
        try {
            return ResponseEntity.ok(employeeServices.updateOneFromXml(employee));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/{ident}")
    public ResponseEntity<String> deleteByident(@PathVariable(value = "ident") Integer ident) {
        try {
            employeeServices.deleteByIdent(ident);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
