/* BlankFactor (C)2024 */
package dev.swapi.api.definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import dev.swapi.api.questions.common.ResponseResultsFieldQuestion;
import dev.swapi.api.questions.common.ValidateApiResponseQuestion;
import dev.swapi.api.questions.startships.PaginationPropertiesExistQuestion;
import dev.swapi.api.tasks.CallApi;
import dev.swapi.api.utils.EnvironmentPropertiesUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.apache.http.HttpStatus;

public class StarshipsStepDefinitions {

    @When("{actor} requests information about all starships")
    public void theUserRequestsInformationAboutAllStarships(Actor actor) {
        String starshipsEndpoint =
                EnvironmentPropertiesUtils.getProperty("swapi.api.starships.endpoint");
        actor.attemptsTo(CallApi.fromEndpoint(starshipsEndpoint));
    }

    @Then("{actor} should receive a successful response containing a list of starships")
    public void theSuccessfulResponseShouldContainAListOfStarships(Actor actor) {
        actor.should(
                seeThat(
                        ValidateApiResponseQuestion.matching(
                                HttpStatus.SC_OK, "swapi.api.starships.schema")),
                seeThat(ResponseResultsFieldQuestion.isNotEmpty()));
    }

    @Then(
            "{actor} should be able to explore the information through the \"next\" and"
                    + " \"previous\" pagination properties")
    public void theResponseShouldIncludePaginationProperties(Actor actor) {
        actor.should(seeThat(PaginationPropertiesExistQuestion.inResponse()));
    }
}
