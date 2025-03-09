package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.ProductsUI;



import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectProduct implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsUI.PRODUCT)
        );
    }

    public static Task selectProd () {
        return instrumented(SelectProduct.class);
    }
}
