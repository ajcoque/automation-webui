package co.com.sofka.tasks.paygrades.currency;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import net.serenitybdd.screenplay.actions.Hover;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.Task;

import static co.com.sofka.userinterfaces.paygrades.currency.Currency.*;

public class FillCurrency implements Task {

    private String nameCurrency;
    private String minSalary;
    private String maxSalary;


    public FillCurrency usingNameCurrency(String nameCurrency) {
        this.nameCurrency = nameCurrency;
        return this;
    }

    public FillCurrency usingMinSalary(String minSalary) {
        this.minSalary = minSalary;
        return this;
    }

    public FillCurrency usingMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ADD_CURRENCY),
                Click.on(ADD_CURRENCY),

                Scroll.to(CURRENCY),
                Enter.theValue(this.nameCurrency).into(CURRENCY),

                Hover.over(SELECT_NAMECURRENCY),
                Click.on(SELECT_NAMECURRENCY),

                Scroll.to(MINIMIUN_SALARY),
                Enter.theValue(this.minSalary).into(MINIMIUN_SALARY),

                Scroll.to(MAXIMIUM_SALARY),
                Enter.theValue(this.maxSalary).into(MAXIMIUM_SALARY),

                Scroll.to(SAVE_CURRENCY),
                Click.on(SAVE_CURRENCY)

        );

    }

    public static FillCurrency fillCurrency() {
        return new FillCurrency();
    }

}
