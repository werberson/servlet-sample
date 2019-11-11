package dev.werberson.sample.metrics;

import br.com.labbs.monitor.dependency.DependencyChecker;
import br.com.labbs.monitor.dependency.DependencyState;

public class FakeDatabaseStateChecker implements DependencyChecker {

    @Override
    public DependencyState run() {
        System.out.println("FakeDatabaseStateChecker.run " + System.currentTimeMillis());
        // check database here
        return DependencyState.UP;
    }

    @Override
    public String getDependencyName() {
        return "fake-database";
    }
}
