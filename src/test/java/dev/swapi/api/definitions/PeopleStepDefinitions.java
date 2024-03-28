/* BlankFactor (C)2024 */
package dev.swapi.api.definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import dev.swapi.api.questions.common.ResponseFieldQuestion;
import dev.swapi.api.questions.common.ValidateApiResponseQuestion;
import dev.swapi.api.tasks.CallApi;
import dev.swapi.api.utils.EnvironmentPropertiesUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.http.HttpStatus;

public class PeopleStepDefinitions {

    @When("the user requests information for the character with identifier {int}")
    public void heRequestInformationForTheCharacterWithIdentifier(int character) {
        String peopleEndpoint = EnvironmentPropertiesUtils.getProperty("swapi.api.people.endpoint");
        OnStage.theActorInTheSpotlight()
                .attemptsTo(CallApi.fromEndpoint(peopleEndpoint.formatted(character)));
    }

    @Then("the character info should be retrieved successfully")
    public void theCharacterInfoShouldBeRetrievedSuccessfully() {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(
                                ValidateApiResponseQuestion.matching(
                                        HttpStatus.SC_OK, "swapi.api.people.schema")));
    }

    @Then("the user should be informed that the character does not found")
    public void theUserShouldBeInformedThatTheCharacterDoesNotFound() {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(
                                ValidateApiResponseQuestion.matching(
                                        HttpStatus.SC_NOT_FOUND, "swapi.api.notfound.schema")));
    }

    @Then("the {word} of the character should be {string}")
    public void theFieldOfThePersonShouldBe(String fieldName, String expectedValue) {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(
                                "Person's " + fieldName,
                                ResponseFieldQuestion.forField(fieldName),
                                equalTo(expectedValue)));
    }
}
