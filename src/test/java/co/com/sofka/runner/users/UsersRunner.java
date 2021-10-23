package co.com.sofka.runner.users;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/users/user.feature"},
        glue = {"co.com.sofka.stepdefinition.users"},
        tags = {"not @ignore"}
)

public class UsersRunner {
}
