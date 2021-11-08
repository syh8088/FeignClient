package com.example.feignclient.api;

import com.example.feignclient.api.client.BoardServiceClient;
import com.example.feignclient.api.model.BoardsRequest;
import com.example.feignclient.api.model.BoardsResponse;
import com.example.feignclient.api.model.SaveBoardRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BasicService {

    private final BoardServiceClient boardServiceClient;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public Object getBoards() {

        BoardsRequest boardsRequest = BoardsRequest.builder()
                .offset(1L)
                .limit(10L)
                .build();


        //BoardsResponse boardList = boardServiceClient.getBoardsV2(boardsRequest);
        BoardsResponse boardsResponse = null;

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("boardServiceClient.getBoardsV2()");
        boardsResponse = circuitBreaker.run(() -> boardServiceClient.getBoardsV2(boardsRequest), throwable -> null);

        System.out.println("boardsResponse = " + boardsResponse);

        return null;
    }

    public Object saveBoard() {

        SaveBoardRequest saveBoardRequest = SaveBoardRequest.builder()
                .title("title test")
                .content("content test")
                .build();

        boardServiceClient.saveBoard(
                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzeWg4MDg4IiwiZXhwIjoxNjM2ODczMDMxLCJpYXQiOjE2MzYyNjgyMzF9.3JOWHtJzKk7f0uZh9Wag0yk2DJW5TJle4qXjnW3sURo",
                saveBoardRequest
        );

        return null;
    }
}
