package co.com.sofka.runner.paygrades;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/paygrades/paygrade.feature"},
        glue = {"co.com.sofka.stepdefinition.paygrades"},
        tags = {"not @ignore"}
)
public class PayGradesRunner {
}
