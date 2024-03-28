/* BlankFactor (C)2024 */
package dev.swapi.api.definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import dev.swapi.api.questions.common.ResponseStatusCodeQuestion;
import dev.swapi.api.utils.EnvironmentPropertiesUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;

public class SharedStepDefinitions {
    @Given("{actor} is a Star Wars fan")
    public void charlesIsAStarWarsFan(Actor actor) {
        if (actor.getName().equals("Fred")) {
            String baseApiUrl = EnvironmentPropertiesUtils.getProperty("swapi.api.base.url");
            actor.can(CallAnApi.at(baseApiUrl));
        }
    }

    @Then("the response should be resource not found")
    public void theResponseShouldBeResourceNotFound() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(ResponseStatusCodeQuestion.hasStatusCode(HttpStatus.SC_NOT_FOUND)));
    }
}
