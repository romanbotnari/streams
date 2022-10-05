package xyz.romanbotnari.streams.configurations;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import xyz.romanbotnari.streams.models.MessageModel;

import java.util.HashMap;
import java.util.Map;

public class ConsumerConfiguration 
{
    @Value("${kafka.server.address}")
    private String kafkaAddress;

    @Value("${kafka.group.id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, xyz.romanbotnari.streams.models.MessageModel> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, xyz.romanbotnari.streams.models.MessageModel.class.getName());

        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        return new DefaultKafkaConsumerFactory<>(props);
        // , new StringDeserializer(), new JsonDeserializer<>(MessageModel.class)
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MessageModel> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MessageModel> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
