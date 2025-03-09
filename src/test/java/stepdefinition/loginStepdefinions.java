package stepdefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import questions.ProductoUI;
import task.RequestData;

import task.Login;
import task.OpenWeb;
import task.SelectProduct;
import ui.ProductsUI;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class loginStepdefinions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("yoli").
                wasAbleTo(OpenWeb.browserURL());
    }
    @Given("enter the sucedemo")
    public void enterTheSucedemo() {
        theActorInTheSpotlight().attemptsTo(
               //
                Login.login()
        );

    }
    @When("I log in")
    public void iLogIn() {
        theActorInTheSpotlight().attemptsTo(
                SelectProduct.selectProd()
        );

    }
    @Then("I will log susessfull")
    public void iWillLogSusessfull() {
        String consulta = "SELECT products FROM db_sausedemo.products WHERE idproducts = 1";
        theActorInTheSpotlight().attemptsTo(
                RequestData.con(consulta, "products")
        );

        String productoDB = theActorInTheSpotlight().recall("products");
        String productoUI = theActorInTheSpotlight().asksFor(ProductoUI.desde(ProductsUI.PRODUCT_NAME));

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(productoUI).isEqualTo(productoDB)
        );
    }
}
