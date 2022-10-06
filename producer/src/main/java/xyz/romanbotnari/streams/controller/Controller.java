package xyz.romanbotnari.streams.controller;

import xyz.romanbotnari.streams.services.*;
import xyz.romanbotnari.streams.models.MessageModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class Controller {

    private final ProducerService producerService;

    @PostMapping("/produce")
    public ResponseEntity<HttpStatus> sendMessage(@RequestBody List<MessageModel> kafkaMessageList) {
        ResponseEntity<HttpStatus> response;
        log.info("/produce");
        log.info("Input {}", kafkaMessageList.toString());
        try { 
            producerService.sendMessage(kafkaMessageList);
            response = new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
