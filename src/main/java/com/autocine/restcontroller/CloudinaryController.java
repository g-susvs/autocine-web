package com.autocine.restcontroller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.autocine.service.CloudinaryService;

@RestController
@RequestMapping("/cloudinary")
public class CloudinaryController {

    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<Map> upload(@RequestParam("folder") String folder,
            @RequestParam("archivo") MultipartFile multipartFile) throws IOException {

        Map result = cloudinaryService.uploaad(folder, multipartFile);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> upload(@PathVariable String id, @RequestParam("folder") String folder)
            throws IOException {
        Map result = cloudinaryService.delete("", id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
