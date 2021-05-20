package com.dropwizard.ms.metrics;

import com.codahale.metrics.health.HealthCheck;

public class HealthCheckMetric extends HealthCheck {
    private final String template;

    public HealthCheckMetric (String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String s = String.format(template, "TEST");
        if(!s.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
