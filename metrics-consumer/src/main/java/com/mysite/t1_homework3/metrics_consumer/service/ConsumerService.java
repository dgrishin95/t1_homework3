package com.mysite.t1_homework3.metrics_consumer.service;

import com.mysite.t1_homework3.metrics_consumer.model.Metric;
import com.mysite.t1_homework3.metrics_consumer.repository.MetricRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerService {

    private final MetricRepository metricRepository;

    public List<Metric> getAllMetrics() {
        return metricRepository.findAll();
    }

    public Metric getMetricById(Long id) {
        return metricRepository.findById(id).orElseThrow(() -> new RuntimeException("Metric not found"));
    }

    @Transactional
    public void saveMetric(Metric metric) {
        Metric savedMetric = metricRepository.save(metric);
        log.info("metric saved {}", savedMetric);
    }
}
