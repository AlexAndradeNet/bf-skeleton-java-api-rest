/* BlankFactor (C)2024 */
package dev.swapi.api.questions.common;

import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class ResponseMatchesSchemaQuestion implements Question<Boolean> {

    private final String schemaPath;

    public ResponseMatchesSchemaQuestion(String schemaPath) {
        this.schemaPath = schemaPath;
    }

    public static ResponseMatchesSchemaQuestion matches(String schemaPath) {
        return new ResponseMatchesSchemaQuestion(schemaPath);
    }

    @Override
    @Subject("validate the response against the schema at #schemaPath")
    public Boolean answeredBy(Actor actor) {
        LastResponse.received()
                .answeredBy(actor)
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
        return true; // If validation passes, return true
    }
}
