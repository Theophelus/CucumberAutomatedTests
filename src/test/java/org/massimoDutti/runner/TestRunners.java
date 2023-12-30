package org.massimoDutti.runner;

import org.testng.annotations.DataProvider;

public interface TestRunners {
    @DataProvider(parallel = true)
    Object[][] scenario();
}
