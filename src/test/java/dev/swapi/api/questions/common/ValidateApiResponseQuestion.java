/* BlankFactor (C)2024 */
package dev.swapi.api.questions.common;

import dev.swapi.api.utils.EnvironmentPropertiesUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class ValidateApiResponseQuestion implements Question<Boolean> {

    private final int expectedStatusCode;
    private final String schemaPath;

    private ValidateApiResponseQuestion(int expectedStatusCode, String schemaPath) {
        this.expectedStatusCode = expectedStatusCode;
        this.schemaPath = schemaPath;
    }

    public static ValidateApiResponseQuestion matching(int expectedStatusCode, String schemaPath) {
        return new ValidateApiResponseQuestion(expectedStatusCode, schemaPath);
    }

    @Override
    @Subject(
            "validate the response status code to be #expectedStatusCode and match schema"
                    + " #schemaPath")
    public Boolean answeredBy(Actor actor) {
        boolean isSameStatusCode =
                ResponseStatusCodeQuestion.hasStatusCode(expectedStatusCode).answeredBy(actor);

        boolean isCorrectContentType =
                ResponseContentTypeQuestion.contentType()
                        .answeredBy(actor)
                        .contains("application/json");

        String resolvedSchemaPath = EnvironmentPropertiesUtils.getProperty(schemaPath);
        boolean isSchemaMatching =
                ResponseMatchesSchemaQuestion.matches(resolvedSchemaPath).answeredBy(actor);

        return isSameStatusCode && isCorrectContentType && isSchemaMatching;
    }

    @Override
    public String toString() {
        // Providing detailed information for better logging
        return String.format(
                "API response should have status %d and match schema %s",
                expectedStatusCode, schemaPath);
    }
}
