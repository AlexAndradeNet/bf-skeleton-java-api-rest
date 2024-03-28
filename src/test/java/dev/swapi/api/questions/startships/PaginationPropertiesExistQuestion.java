/* BlankFactor (C)2024 */
package dev.swapi.api.questions.startships;

import dev.swapi.api.questions.common.ResponseFieldQuestion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PaginationPropertiesExistQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        var next = ResponseFieldQuestion.forField("next").answeredBy(actor);
        var previous = ResponseFieldQuestion.forField("previous").answeredBy(actor);
        return next != null || previous != null;
    }

    public static PaginationPropertiesExistQuestion inResponse() {
        return new PaginationPropertiesExistQuestion();
    }
}
