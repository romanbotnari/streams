package xyz.romanbotnari.streams.services;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import xyz.romanbotnari.streams.models.*;

@Service
@Slf4j
public class ConsumerService {
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(List<MessageModel> messageModel) {
        log.info("Message received. Message : {} ", messageModel);
        log.info("Sleeping for .. {} seconds", ConsumerTestConfiguration.getInstance().getLag());
        try {
            Thread.sleep(ConsumerTestConfiguration.getInstance().getLag());
        } catch(InterruptedException ie) {
            log.error("I just can't sleep..");
        }
    }
}
