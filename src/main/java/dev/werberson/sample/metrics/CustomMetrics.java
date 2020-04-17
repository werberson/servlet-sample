package dev.werberson.sample.metrics;

import br.com.labbs.monitor.MonitorMetrics;
import io.prometheus.client.Counter;

public class CustomMetrics {

    public Counter customCounter;

    private static CustomMetrics INSTANCE;

    private CustomMetrics() {
        this.customCounter = Counter.build().name("my_custom_metric")
                .help("custom metric registered and exposed by MonitorMetrics")
                .labelNames("custom_label")
                .register(MonitorMetrics.INSTANCE.collectorRegistry);
    }

    public static CustomMetrics getInstance() {
        if (INSTANCE == null) {
            synchronized (CustomMetrics.class) {
                INSTANCE = new CustomMetrics();
            }
        }
        return INSTANCE;
    }
}
