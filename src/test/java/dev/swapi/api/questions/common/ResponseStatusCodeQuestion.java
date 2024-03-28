/* BlankFactor (C)2024 */
package dev.swapi.api.questions.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

/** A question to verify if the last response received has the expected HTTP status code. */
public class ResponseStatusCodeQuestion implements Question<Boolean> {

    private final int expectedStatusCode;

    private ResponseStatusCodeQuestion(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    public static ResponseStatusCodeQuestion hasStatusCode(int expectedStatusCode) {
        return new ResponseStatusCodeQuestion(expectedStatusCode);
    }

    @Override
    @Subject("validate the response status code to be #expectedStatusCode")
    public Boolean answeredBy(Actor actor) {
        int actualStatusCode = LastResponse.received().answeredBy(actor).getStatusCode();
        return actualStatusCode == expectedStatusCode;
    }

    @Override
    public String toString() {
        return String.format("the response status code to be %d", expectedStatusCode);
    }
}
