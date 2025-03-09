package runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",  // Ruta correcta a los archivos .feature
        glue = "stepdefinition",      // Paquete con las StepDefinitions
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class login {
}
