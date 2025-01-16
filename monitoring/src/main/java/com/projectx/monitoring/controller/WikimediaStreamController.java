package com.projectx.monitoring.controller;

import com.projectx.monitoring.entity.WikimediaRecordEntity;
import com.projectx.monitoring.service.WikimediaStreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/monitoring")
public class WikimediaStreamController {
    private final WikimediaStreamService wikimediaStreamService;

    @PostMapping()
    public ResponseEntity<HttpStatus> consumeData(@RequestBody WikimediaRecordEntity record) {
        wikimediaStreamService.consumeData(record);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
