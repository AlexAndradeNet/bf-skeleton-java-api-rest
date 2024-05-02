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
import net.serenitybdd.screenplay.Actor;
import org.apache.http.HttpStatus;

public class PeopleStepDefinitions {

    @When("{actor} requests information for the character with identifier {int}")
    public void heRequestInformationForTheCharacterWithIdentifier(Actor actor, int character) {
        String peopleEndpoint = EnvironmentPropertiesUtils.getProperty("swapi.api.people.endpoint");
        actor.attemptsTo(CallApi.fromEndpoint(peopleEndpoint.formatted(character)));
    }

    @Then("{actor} should receive the character info successfully")
    public void theCharacterInfoShouldBeRetrievedSuccessfully(Actor actor) {
        actor.should(
                seeThat(
                        ValidateApiResponseQuestion.matching(
                                HttpStatus.SC_OK, "swapi.api.people.schema")));
    }

    @Then("{actor} should be informed that the character does not found")
    public void theUserShouldBeInformedThatTheCharacterDoesNotFound(Actor actor) {
        actor.should(
                seeThat(
                        ValidateApiResponseQuestion.matching(
                                HttpStatus.SC_NOT_FOUND, "swapi.api.notfound.schema")));
    }

    @Then("{actor} should see that the character's {word} is {string}")
    public void theFieldOfThePersonShouldBe(Actor actor, String fieldName, String expectedValue) {
        actor.should(
                seeThat(
                        "Person's " + fieldName,
                        ResponseFieldQuestion.forField(fieldName),
                        equalTo(expectedValue)));
    }
}
