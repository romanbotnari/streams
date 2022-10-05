package xyz.romanbotnari.streams.services;

import xyz.romanbotnari.streams.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {

    @Value("${kafka.topic.name}")
    private String topic;

    private final KafkaTemplate<String, MessageModel> kafkaTemplate;

    public void sendMessage(@RequestBody List<MessageModel> kafkaMessageList) {
        kafkaMessageList.forEach(kafkaMessage -> 
            kafkaTemplate.send(topic, kafkaMessage)
        );
    }
}