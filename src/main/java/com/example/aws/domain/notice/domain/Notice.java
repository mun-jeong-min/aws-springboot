package com.example.aws.domain.notice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Builder
    public Notice(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateNotice(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
