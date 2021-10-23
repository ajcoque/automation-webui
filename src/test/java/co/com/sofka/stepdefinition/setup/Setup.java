package co.com.sofka.stepdefinition.setup;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.PropertyConfigurator;
import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Setup {

    protected static final String USER_DIR = System.getProperty("user.dir");
    @Managed()
    protected WebDriver browser;

    protected void setupBrowser(WebDriver browser) {
        browser.manage().deleteAllCookies();
        browser.manage().window().maximize();
    }

    protected void setupUser(String name, WebDriver browser) {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(BrowseTheWeb.with(browser));
    }

    protected void actorSetupTheBrowser(String actorName) {
        setUpLog4j2();
        setupBrowser(browser);
        setupUser(actorName, browser);
    }

    protected void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

}
