package com.example.aws.domain.notice.present;

import com.example.aws.domain.notice.domain.Notice;
import com.example.aws.domain.notice.present.dto.request.NoticeCreateRequest;
import com.example.aws.domain.notice.present.dto.request.NoticeUpdateRequest;
import com.example.aws.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void noticeCreate(@RequestBody NoticeCreateRequest request) {
        noticeService.noticeCreate(request);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void noticeUpdate(@PathVariable("id") Long id, @RequestBody NoticeUpdateRequest request) {
        noticeService.updateNotice(id, request);
    }

    @GetMapping("/get")
    public List<Notice> noticeRead() {
        return noticeService.noticeRead();
    }

    @GetMapping("/get/{id}")
    public Optional<Notice> noticeReadOne(@PathVariable("id") Long id) {
        return noticeService.noticeReadOne(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void noticeDelete(@PathVariable("id") Long id) {
        noticeService.deleteNotice(id);
    }
}
