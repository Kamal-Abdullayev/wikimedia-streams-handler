package com.projectx.producer.controller;

import com.projectx.producer.service.WikimediaStreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class WikimediaProducerController {
    private final WikimediaStreamService wikimediaStreamService;

    @GetMapping("/start")
    public ResponseEntity<HttpStatusCode> startStream() {
        wikimediaStreamService.startStream();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/stop")
    public ResponseEntity<HttpStatusCode> stopStream() {
        wikimediaStreamService.stopStream();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
