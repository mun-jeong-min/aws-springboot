package com.example.aws.domain.notice.present.dto.response;

import com.example.aws.domain.notice.domain.Notice;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class NoticeResponse {
    List<Notice> list;
}
