package com.example.softlearning.presentation.api.rest;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.softlearning.applicationcore.entity.client.appservices.ClientServices;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/softlearning/clients")
public class RestClientController {
    @Autowired
    ClientServices clientServices;

    @GetMapping(value = "/{ident}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonClientByIdent(@PathVariable(value = "ident") Integer ident) {
        try {
            return ResponseEntity.ok(clientServices.getByIdentToJson(ident));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping(value = "/{ident}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getXmlClientByIdent(@PathVariable(value = "ident") Integer ident) {
        try {
            return ResponseEntity.ok(clientServices.getByIdentToXml(ident));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newClientFromJson(@RequestBody String client) {
        try {
            return ResponseEntity.ok(clientServices.addFromJson(client));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> newClientFromXml(@RequestBody String client) {
        try {
            return ResponseEntity.ok(clientServices.addFromXml(client));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{ident}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateClientFromJson(@PathVariable(value = "ident") Integer ident,
    @RequestBody String client) {
        try {
            return ResponseEntity.ok(clientServices.updateOneFromJson(client));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{ident}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> updateClientFromXml(@PathVariable(value = "ident") Integer ident,
    @RequestBody String client) {
        try {
            return ResponseEntity.ok(clientServices.updateOneFromXml(client));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/{ident}")
    public ResponseEntity<String> deleteByident(@PathVariable(value = "ident") Integer ident) {
        try {
            clientServices.deleteByIdent(ident);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    /*     @DeleteMapping("/{code}")
 */
}
