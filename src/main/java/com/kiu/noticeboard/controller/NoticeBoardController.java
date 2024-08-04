package com.kiu.noticeboard.controller;

import com.kiu.noticeboard.entity.Notice;
import com.kiu.noticeboard.service.NoticeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/notices")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class NoticeBoardController {

    private final NoticeService service;

    @PostMapping("/create")
    public ResponseEntity<Notice> createNotice(@Valid @RequestBody Notice notice){
        return new ResponseEntity<>(service.createNotice(notice), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Notice>>findAllNotices(){
        return new ResponseEntity<List<Notice>>(service.getAllNotices(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notice> updateNote(@PathVariable(value = "id") Long noticeId,
                           @Valid @RequestBody Notice notice) {
        return new ResponseEntity<>(service.update(noticeId,notice), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noticeId) {
        service.delete(noticeId);
        return ResponseEntity.ok().build();
    }

}
