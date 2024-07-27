package com.kiu.noticeboard.repository;

import com.kiu.noticeboard.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Long> {
}
