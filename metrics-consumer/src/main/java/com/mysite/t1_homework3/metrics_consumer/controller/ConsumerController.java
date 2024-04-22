package com.mysite.t1_homework3.metrics_consumer.controller;

import com.mysite.t1_homework3.metrics_consumer.model.Metric;
import com.mysite.t1_homework3.metrics_consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
public class ConsumerController {

    private final ConsumerService consumerService;

    @GetMapping
    public ResponseEntity<List<Metric>> getAllTasks() {
        return new ResponseEntity<>(consumerService.getAllMetrics(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metric> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(consumerService.getMetricById(id));
    }
}
