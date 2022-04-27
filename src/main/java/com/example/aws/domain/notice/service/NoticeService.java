package com.example.aws.domain.notice.service;

import com.example.aws.domain.notice.domain.Notice;
import com.example.aws.domain.notice.domain.repository.NoticeRepository;
import com.example.aws.domain.notice.present.dto.request.NoticeCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public void noticeCreate(NoticeCreateRequest request) {
        noticeRepository.save(
                Notice.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()
        );
    }
}
