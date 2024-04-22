package com.mysite.t1_homework3.metrics_producer.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.t1_homework3.metrics_producer.dto.MetricRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Producer {

    @Value("${topic.name}")
    private String metricTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(MetricRequest metric) throws JsonProcessingException {
        String topicAsMessage = objectMapper.writeValueAsString(metric);
        kafkaTemplate.send(metricTopic, topicAsMessage);

        log.info("metric produced {}", topicAsMessage);

        return "message sent";
    }
}
