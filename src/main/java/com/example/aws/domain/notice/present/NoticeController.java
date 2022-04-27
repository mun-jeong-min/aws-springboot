package com.example.aws.domain.notice.present;

import com.example.aws.domain.notice.present.dto.request.NoticeCreateRequest;
import com.example.aws.domain.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void noticeCreate(@RequestBody NoticeCreateRequest request) {
        noticeService.noticeCreate(request);
    }
}
