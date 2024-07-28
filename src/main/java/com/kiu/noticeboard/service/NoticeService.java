package com.kiu.noticeboard.service;

import com.kiu.noticeboard.entity.Notice;
import com.kiu.noticeboard.exception.NoticeNotFoundException;
import com.kiu.noticeboard.repository.NoticeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository repository;

    @Transactional
    public Notice createNotice(Notice notice){
        return repository.save(notice);
    }

    public List<Notice> getAllNotices(){
        return repository.findAll();
    }

    public Notice findNoticeById(Long noticeId){
       return repository.findById(noticeId).orElseThrow(() -> new NoticeNotFoundException("Notice not found with ID: " + noticeId));
    }

    @Transactional
    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new NoticeNotFoundException("Notice not found with ID: " + id);
        }
    }

    @Transactional
    public Notice update(Long id, Notice newNotice){
        Notice oldNotice= repository.findById(id).orElseThrow(()->throw new NoticeNotFoundException("Notice not found with ID "+id));
            oldNotice.setAdmin(newNotice.getAdmin());
            oldNotice.setRuleName(newNotice.getRuleName());
         return  repository.save(oldNotice);
    }

}
