package xyz.romanbotnari.streams.controller;

import xyz.romanbotnari.streams.services.*;
import xyz.romanbotnari.streams.models.MessageModel;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final ProducerService producerService;

    @PostMapping("/produce")
    public void sendMessage(@RequestBody List<MessageModel> kafkaMessageList) {
        producerService.sendMessage(kafkaMessageList);
    }

}
