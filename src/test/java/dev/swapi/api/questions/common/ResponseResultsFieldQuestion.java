/* BlankFactor (C)2024 */
package dev.swapi.api.questions.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseResultsFieldQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Integer starships =
                Integer.parseInt(
                        ResponseFieldQuestion.forField("results.size()")
                                .answeredBy(actor)
                                .toString());
        return starships != null && starships > 0;
    }

    public static ResponseResultsFieldQuestion isNotEmpty() {
        return new ResponseResultsFieldQuestion();
    }
}
