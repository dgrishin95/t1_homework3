package com.mysite.t1_homework3.metrics_producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysite.t1_homework3.metrics_producer.dto.MetricRequest;
import com.mysite.t1_homework3.metrics_producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
@Slf4j
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping
    public String createMetric(@RequestBody MetricRequest metric) throws JsonProcessingException {
        log.info("create metric request received");
        return producerService.createMetric(metric);
    }
}

