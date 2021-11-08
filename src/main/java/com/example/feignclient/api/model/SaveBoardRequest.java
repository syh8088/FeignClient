package com.example.feignclient.api.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveBoardRequest {

    private String title;
    private String content;

    @Builder
    public SaveBoardRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
