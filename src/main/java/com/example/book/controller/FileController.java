package com.example.book.controller;

import com.example.book.service.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public class FileController {
    private StorageService storageService;

    public FileController(StorageService storageService){
        this.storageService = storageService;
    }

    @GetMapping(value = "/images/{filename:.+}", produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE})
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename){
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok(file);
    }
}
