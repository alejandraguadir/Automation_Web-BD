package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import ui.LoginUi;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SendKeys.of("standard_user").into(LoginUi.INPUT_USER),
                SendKeys.of("secret_sauce").into(LoginUi.INPUT_PASS),
                Click.on(LoginUi.BUTTON_LOGIN)

        );
    }

    public static Task login() {
        return instrumented(Login.class);
    }

}
