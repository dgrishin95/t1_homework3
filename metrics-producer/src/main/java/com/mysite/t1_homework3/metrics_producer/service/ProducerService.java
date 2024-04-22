package com.mysite.t1_homework3.metrics_producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysite.t1_homework3.metrics_producer.dto.MetricRequest;
import com.mysite.t1_homework3.metrics_producer.service.producer.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {

    private final Producer producer;

    public String createMetric(MetricRequest metric) throws JsonProcessingException {
        return producer.sendMessage(metric);
    }
}
