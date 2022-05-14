package com.example.aws.domain.notice.service;

import com.example.aws.domain.notice.domain.Notice;
import com.example.aws.domain.notice.domain.repository.NoticeRepository;
import com.example.aws.domain.notice.exception.NoticeNotFoundException;
import com.example.aws.domain.notice.present.dto.request.NoticeCreateRequest;
import com.example.aws.domain.notice.present.dto.request.NoticeUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public List<Notice> noticeRead() {
        return (List<Notice>) noticeRepository.findAll();
    }

    public Optional<Notice> noticeReadOne(Long id) {
        return noticeRepository.findNoticeById(id);
    }

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

    @Transactional
    public void deleteNotice(Long id) {
        Notice notice = noticeRepository.findNoticeById(id)
                        .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        noticeRepository.delete(notice);
    }
}
