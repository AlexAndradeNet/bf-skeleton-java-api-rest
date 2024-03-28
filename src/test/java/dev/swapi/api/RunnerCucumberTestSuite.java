/* BlankFactor (C)2023 */
package dev.swapi.api;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value =
                "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline")
@ExcludeTags("@skip")
public class RunnerCucumberTestSuite {
    // Runner class content
}
