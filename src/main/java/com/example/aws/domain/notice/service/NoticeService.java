package com.example.aws.domain.notice.service;

import com.example.aws.domain.notice.domain.Notice;
import com.example.aws.domain.notice.domain.repository.NoticeRepository;
import com.example.aws.domain.notice.exception.NoticeNotFoundException;
import com.example.aws.domain.notice.present.dto.request.NoticeCreateRequest;
import com.example.aws.domain.notice.present.dto.request.NoticeUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void updateNotice(Long id, NoticeUpdateRequest request) {
        Notice notice = noticeRepository.findNoticeById(id)
                        .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        notice.updateNotice(request.getTitle(), request.getContent());
    }
}
