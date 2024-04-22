package com.mysite.t1_homework3.metrics_producer.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class MetricRequest {
    String applicationVersion;
    Double responseTime;
}
