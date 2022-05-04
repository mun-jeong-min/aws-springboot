package com.example.aws.domain.notice.present;

import com.example.aws.domain.notice.domain.Notice;
import com.example.aws.domain.notice.present.dto.request.NoticeCreateRequest;
import com.example.aws.domain.notice.present.dto.request.NoticeUpdateRequest;
import com.example.aws.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void noticeCreate(@RequestBody @Valid NoticeCreateRequest request) {
        noticeService.noticeCreate(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void noticeUpdate(@PathVariable("id") Long id, @RequestBody @Valid NoticeUpdateRequest request) {
        noticeService.updateNotice(id, request);
    }

    @GetMapping("/")
    public List<Notice> noticeRead() {
        return noticeService.noticeRead();
    }

    @GetMapping("/{id}")
    public Optional<Notice> noticeReadOne(@PathVariable("id") Long id) {
        return noticeService.noticeReadOne(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void noticeDelete(@PathVariable("id") Long id) {
        noticeService.deleteNotice(id);
    }
}
