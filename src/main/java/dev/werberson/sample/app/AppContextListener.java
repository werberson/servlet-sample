package dev.werberson.sample.app;

import br.com.labbs.monitor.MonitorMetrics;
import dev.werberson.sample.metrics.FakeDatabaseStateChecker;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Used only for initialize the dependencies metrics collectors
 */
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initializeDependenciesMetricsCollectors();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //ignored
    }

    private void initializeDependenciesMetricsCollectors() {
        FakeDatabaseStateChecker checker = new FakeDatabaseStateChecker();
        long periodInMillis = 15000L;
        MonitorMetrics.INSTANCE.addDependencyChecker(checker, periodInMillis);
    }
}
