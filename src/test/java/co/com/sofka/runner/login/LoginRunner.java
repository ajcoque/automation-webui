package co.com.sofka.runner.login;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/login/login.feature"},
        glue = {"co.com.sofka.stepdefinition.login"},
        tags = {"not @ignore"}
)

public class LoginRunner {
}
