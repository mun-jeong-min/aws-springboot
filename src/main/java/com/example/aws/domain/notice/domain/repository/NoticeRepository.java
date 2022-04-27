package com.example.aws.domain.notice.domain.repository;

import com.example.aws.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
}
