package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenWeb implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.url("https://www.saucedemo.com/v1/index.html"));
    }
    public static Task browserURL() {
        return instrumented(OpenWeb.class);
    }
}
