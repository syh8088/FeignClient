package com.example.feignclient.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardsResponse {

    private long totalPages;
    private long totalElements;
    private long number;
    private long size;
    private List<BoardResponse> boardResponses;
}
