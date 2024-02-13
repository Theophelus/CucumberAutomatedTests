package org.anele.runner;

import org.testng.annotations.DataProvider;

public interface TestRunners {
    @DataProvider(parallel = true)
    Object[][] scenario();
}
