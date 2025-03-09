package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUi extends PageObject {

    public static final Target INPUT_USER= Target.the("Input user")
            .located(By.xpath("//*[@id=\"user-name\"]"));

    public static final Target INPUT_PASS= Target.the("Input pass")
            .located(By.xpath("//*[@id=\"password\"]"));

    public static final Target BUTTON_LOGIN= Target.the("Button login")
            .located(By.xpath("//*[@id=\"login-button\"]"));
}
