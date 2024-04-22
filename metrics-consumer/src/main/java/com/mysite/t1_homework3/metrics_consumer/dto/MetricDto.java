package com.mysite.t1_homework3.metrics_consumer.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class MetricDto {
    String applicationVersion;
    Double responseTime;
}
