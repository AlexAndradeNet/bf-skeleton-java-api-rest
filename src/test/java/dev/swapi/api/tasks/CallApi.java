/* BlankFactor (C)2024 */
package dev.swapi.api.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.interactions.Get;

@Subject("Fetch resource")
public class CallApi implements Task {

    private final String endpoint;

    public CallApi(String endpoint) {
        this.endpoint = endpoint;
    }

    public static CallApi fromEndpoint(String endpoint) {
        return instrumented(CallApi.class, endpoint);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(endpoint));
    }
}
