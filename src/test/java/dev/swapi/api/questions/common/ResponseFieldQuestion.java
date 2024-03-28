/* BlankFactor (C)2024 */
package dev.swapi.api.questions.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

/** A question to retrieve the value of a specific field from the last response. */
public class ResponseFieldQuestion implements Question<Object> {

    private final String fieldName;

    private ResponseFieldQuestion(String fieldName) {
        this.fieldName = fieldName;
    }

    public static ResponseFieldQuestion forField(String fieldName) {
        return new ResponseFieldQuestion(fieldName);
    }

    @Override
    public Object answeredBy(Actor actor) {
        return LastResponse.received().answeredBy(actor).jsonPath().get(fieldName);
    }

    @Override
    public String toString() {
        // This provides a more descriptive text for logging and reporting purposes.
        return String.format("the value of the field '%s'", fieldName);
    }
}
