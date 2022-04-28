package com.example.aws.domain.notice.domain.repository;

import com.example.aws.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
    Optional<Notice> findNoticeById(Long id);
}
