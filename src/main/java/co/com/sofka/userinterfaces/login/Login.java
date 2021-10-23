package co.com.sofka.userinterfaces.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class Login extends PageObject {
    public static final Target USERNAME = Target
            .the("Username")
            .located(id("txtUsername"));

    public static final Target PASSWORD = Target
            .the("Password")
            .located(id("txtPassword"));

    public static final Target LOGIN = Target
            .the("Login")
            .located(id("btnLogin"));

    //For validations.
    public static final Target VALIDATION_DASHBOARD = Target
            .the("Dashboard")
            .located(xpath("//*[@id=\"content\"]/div/div[1]/h1"));

    public static final Target VALIDATION_SPANMESSAGE = Target
            .the("spanMessage")
            .located(id("spanMessage"));

}