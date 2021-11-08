package com.example.feignclient.api.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardsRequest {

    private String title;
    private String sort;
    private String order;
    private Long offset = 1L;
    private Long limit = 10L;

    @Builder
    public BoardsRequest(String title, String sort, String order, Long offset, Long limit) {
        this.title = title;
        this.sort = sort;
        this.order = order;
        this.offset = offset;
        this.limit = limit;
    }
}
