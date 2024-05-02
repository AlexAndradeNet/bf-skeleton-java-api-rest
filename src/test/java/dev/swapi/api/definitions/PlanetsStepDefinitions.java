/* BlankFactor (C)2024 */
package dev.swapi.api.definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

import dev.swapi.api.questions.common.ResponseResultsFieldQuestion;
import dev.swapi.api.questions.common.ValidateApiResponseQuestion;
import dev.swapi.api.questions.planets.ThePlanetQuestion;
import dev.swapi.api.tasks.CallApi;
import dev.swapi.api.utils.EnvironmentPropertiesUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.apache.http.HttpStatus;

public class PlanetsStepDefinitions {

    @When("{actor} requests information for the planet {string}")
    public void theUserRequestsInformationForThePlanet(Actor actor, String planetName) {
        String planetsEndpoint =
                EnvironmentPropertiesUtils.getProperty("swapi.api.planets.endpoint");
        actor.attemptsTo(CallApi.fromEndpoint(planetsEndpoint.formatted(planetName)));
    }

    @Then("{actor} should receive a successful response containing a list of planets")
    public void theSuccessfulResponseShouldContainAListOfPlanets(Actor actor) {
        actor.should(
                seeThat(
                        ValidateApiResponseQuestion.matching(
                                HttpStatus.SC_OK, "swapi.api.planets.schema")),
                seeThat(ResponseResultsFieldQuestion.isNotEmpty()));
    }

    @Then("{actor} should see that the {word} of the first planet listed is {string}")
    public void theFieldOfTheFirstPlanetInTheListShouldBe(
            Actor actor, String fieldName, String expectedValue) {
        actor.should(
                seeThat(
                        "Planet name",
                        ThePlanetQuestion.fieldOfFirstPlanet(fieldName),
                        equalTo(expectedValue)));
    }
}
