package com.kiu.noticeboard.service;

import com.kiu.noticeboard.entity.Notice;
import com.kiu.noticeboard.repository.NoticeRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeRepository repository;

    public Notice createNotice(Notice notice){
        return repository.save(notice);
    }

    public List<Notice> getAllNotices(){
        return repository.findAll();
    }

}
