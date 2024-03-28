/* BlankFactor (C)2024 */
package dev.swapi.api.questions.planets;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class ThePlanetQuestion implements Question<String> {

    private final String fieldName;

    private ThePlanetQuestion(String fieldName) {
        this.fieldName = fieldName;
    }

    public static ThePlanetQuestion fieldOfFirstPlanet(String fieldName) {
        return new ThePlanetQuestion(fieldName);
    }

    @Override
    public String answeredBy(Actor actor) {
        return LastResponse.received().answeredBy(actor).jsonPath().get("results[0]." + fieldName);
    }

    @Override
    public String toString() {
        // This provides a more descriptive text for logging and reporting purposes.
        return String.format("the value of the field '%s'", fieldName);
    }
}
