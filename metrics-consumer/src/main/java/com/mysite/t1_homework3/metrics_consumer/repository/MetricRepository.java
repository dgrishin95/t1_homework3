package com.mysite.t1_homework3.metrics_consumer.repository;

import com.mysite.t1_homework3.metrics_consumer.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {
}
