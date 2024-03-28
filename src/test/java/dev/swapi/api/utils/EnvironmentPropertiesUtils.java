/* BlankFactor (C)2023 */
package dev.swapi.api.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;

public final class EnvironmentPropertiesUtils {
    private static final SystemEnvironmentVariables ENVIRONMENT_VARIABLES =
            SystemEnvironmentVariables.createEnvironmentVariables();

    private EnvironmentPropertiesUtils() {
        // Private constructor to prevent instantiation
    }

    public static String getProperty(String propertyName) {
        return EnvironmentSpecificConfiguration.from(ENVIRONMENT_VARIABLES)
                .getProperty(propertyName);
    }
}
