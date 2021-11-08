package com.example.feignclient.api.client;

import com.example.feignclient.api.config.HeaderConfiguration;
import com.example.feignclient.api.model.BoardsRequest;
import com.example.feignclient.api.model.BoardsResponse;
import com.example.feignclient.api.model.SaveBoardRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="test", url = "${environments.internal-server-url}")
public interface BoardServiceClient {

    @GetMapping(value = "/api/boards")
    BoardsResponse getBoardsV1(@RequestParam("offset") Long offset, @RequestParam("limit") Long limit);

    @GetMapping(value = "/api/boardsTEST")
    BoardsResponse getBoardsV2(@SpringQueryMap @ModelAttribute BoardsRequest boardsRequest);

    @PostMapping(value = "/api/boards")
    void saveBoard(@RequestHeader("accessToken") String headers, @RequestBody SaveBoardRequest saveBoardRequest);
}
