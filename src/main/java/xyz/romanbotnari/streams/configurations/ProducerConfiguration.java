package xyz.romanbotnari.streams.configurations;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import xyz.romanbotnari.streams.models.MessageModel;
import org.apache.kafka.clients.producer.ProducerConfig;

@Configuration
public class ProducerConfiguration {

    @Value("${kafka.server.address}")
    private String kafkaAddress;

    @Bean
    public ProducerFactory producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, MessageModel> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}