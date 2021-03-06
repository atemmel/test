/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.filetransformation.CodecBase64;
import java.io.File;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.antonsSkafferi.rest.webservices.restfulwebservices.constants.*;
/**
 *
 * @author Allamo Olsson
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ImageController {
    
    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(
      path = "/images"
    )
    static public ResponseEntity<String> getImageWithMediaType(@RequestParam String path) throws IOException, Exception {
        System.out.println("path: " + path);
        File tempFile = new File(path);
      
         return !tempFile.exists() ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : ResponseEntity.ok(CodecBase64.encode(tempFile, true));//!tempFile.exists() ? null : CodecBase64.encode(tempFile, true);
    }
    
    
} 