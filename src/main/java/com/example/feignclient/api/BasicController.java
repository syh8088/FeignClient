package com.example.feignclient.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class BasicController {

    private final BasicService basicService;

    @GetMapping
    public ResponseEntity<?> getBoards() {

        return ResponseEntity.ok().body(basicService.getBoards());
    }

    @PostMapping
    public ResponseEntity<?> saveBoard() {

        return ResponseEntity.ok().body(basicService.saveBoard());
    }
}
