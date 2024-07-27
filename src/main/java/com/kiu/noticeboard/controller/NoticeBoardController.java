package com.kiu.noticeboard.controller;

import com.kiu.noticeboard.entity.Notice;
import com.kiu.noticeboard.service.NoticeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/notices")
public class NoticeBoardController {

    @Autowired
    private NoticeService service;

    @PostMapping
    public ResponseEntity<Notice> createNotice(@Valid @RequestBody Notice notice){
        return new ResponseEntity<>(service.createNotice(notice), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Notice>>findAllNotices(){
        return new ResponseEntity<List<Notice>>(service.getAllNotices(),HttpStatus.OK);
    }
}
