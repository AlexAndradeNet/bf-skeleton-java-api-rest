/* BlankFactor (C)2024 */
package dev.swapi.api.questions.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class ResponseContentTypeQuestion implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LastResponse.received().answeredBy(actor).contentType();
    }

    public static ResponseContentTypeQuestion contentType() {
        return new ResponseContentTypeQuestion();
    }

    @Override
    public String toString() {
        // This provides a more descriptive text for logging and reporting purposes.
        return "the content type of the response";
    }
}
