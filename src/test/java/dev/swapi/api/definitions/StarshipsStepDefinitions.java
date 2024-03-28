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
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.http.HttpStatus;

public class StarshipsStepDefinitions {

    @When("the user requests information about all starships")
    public void theUserRequestsInformationAboutAllStarships() {
        String starshipsEndpoint =
                EnvironmentPropertiesUtils.getProperty("swapi.api.starships.endpoint");
        OnStage.theActorInTheSpotlight().attemptsTo(CallApi.fromEndpoint(starshipsEndpoint));
    }

    @Then("the successful response should contain a list of starships")
    public void theSuccessfulResponseShouldContainAListOfStarships() {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(
                                ValidateApiResponseQuestion.matching(
                                        HttpStatus.SC_OK, "swapi.api.starships.schema")),
                        seeThat(ResponseResultsFieldQuestion.isNotEmpty()));
    }

    @Then("the response should include pagination properties \"next\" and \"previous\"")
    public void theResponseShouldIncludePaginationProperties() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(PaginationPropertiesExistQuestion.inResponse()));
    }
}
