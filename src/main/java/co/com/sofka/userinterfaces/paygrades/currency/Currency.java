package co.com.sofka.userinterfaces.paygrades.currency;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class Currency extends PageObject {

    public static final Target ADD_CURRENCY = Target
            .the("Add Currency")
            .located(id("btnAddCurrency"));

    public static final Target CURRENCY = Target
            .the("Currency")
            .located(id("payGradeCurrency_currencyName"));

    public static final Target SELECT_NAMECURRENCY = Target
            .the("Select Name Currency")
            .located(xpath("/html/body/div[4]/ul/li"));

    public static final Target MINIMIUN_SALARY = Target
            .the("Minimium Salary")
            .located(id("payGradeCurrency_minSalary"));

    public static final Target MAXIMIUM_SALARY = Target
            .the("Maximiun Salary")
            .located(id("payGradeCurrency_maxSalary"));

    public static final Target SAVE_CURRENCY = Target
            .the("Save Currency")
            .located(id("btnSaveCurrency"));


    public static final Target VALIDATION_NAMECUREENCY = Target
            .the("Validation Name Currency")
            .located(xpath("//*[@id=\"tblCurrencies\"]/tbody/tr/td[2]/a"));

    public static final Target VALIDATION_MINSALARY = Target
            .the("Validation MinSalary")
            .located(xpath("//*[@id=\"tblCurrencies\"]/tbody/tr/td[3]"));

    public static final Target VALIDATION_MAXSALARY = Target
            .the("Validation MaxSalary")
            .located(xpath("//*[@id=\"tblCurrencies\"]/tbody/tr/td[4]"));
}
