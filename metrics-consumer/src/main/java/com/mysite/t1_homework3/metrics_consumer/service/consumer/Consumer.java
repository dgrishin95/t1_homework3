package com.mysite.t1_homework3.metrics_consumer.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysite.t1_homework3.metrics_consumer.dto.MetricDto;
import com.mysite.t1_homework3.metrics_consumer.model.Metric;
import com.mysite.t1_homework3.metrics_consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    private static final String metricTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final ConsumerService consumerService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, ConsumerService consumerService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.consumerService = consumerService;
    }

    @KafkaListener(topics = metricTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        MetricDto metricDto = objectMapper.readValue(message, MetricDto.class);
        Metric metric = modelMapper.map(metricDto, Metric.class);

        consumerService.saveMetric(metric);
    }
}
