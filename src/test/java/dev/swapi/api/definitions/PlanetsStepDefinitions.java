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
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.http.HttpStatus;

public class PlanetsStepDefinitions {

    @When("the user requests information for the planet {string}")
    public void theUserRequestsInformationForThePlanet(String planetName) {
        String planetsEndpoint =
                EnvironmentPropertiesUtils.getProperty("swapi.api.planets.endpoint");
        OnStage.theActorInTheSpotlight()
                .attemptsTo(CallApi.fromEndpoint(planetsEndpoint.formatted(planetName)));
    }

    @Then("the successful response should contain a list of planets")
    public void theSuccessfulResponseShouldContainAListOfPlanets() {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(
                                ValidateApiResponseQuestion.matching(
                                        HttpStatus.SC_OK, "swapi.api.planets.schema")),
                        seeThat(ResponseResultsFieldQuestion.isNotEmpty()));
    }

    @Then("the {string} field of the first planet in the list should be {string}")
    public void theFieldOfTheFirstPlanetInTheListShouldBe(String fieldName, String expectedValue) {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(
                                "Planet name",
                                ThePlanetQuestion.fieldOfFirstPlanet(fieldName),
                                equalTo(expectedValue)));
    }
}
