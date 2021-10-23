package co.com.sofka.questions.paygrades.currency;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.paygrades.currency.Currency.*;

public class Currency implements Question<Boolean> {

    private String nameCurrency;
    private String minimumSalary;
    private String maximumSalary;

    public Currency wasFilledWithNameCurrency(String nameCurrency) {
        this.nameCurrency = nameCurrency;
        return this;
    }

    public Currency andWithMinimumSalary(String minimumSalary) {
        this.minimumSalary = minimumSalary;
        return this;
    }

    public Currency andWithMaximumSalary(String maximumSalary) {
        this.maximumSalary = maximumSalary;
        return this;
    }

    public Currency is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        //Se coloca manualmente porque el formato en el que llega es diferente al que se envia
        return (VALIDATION_NAMECUREENCY.resolveFor(actor).containsOnlyText(nameCurrency)
                && VALIDATION_MINSALARY.resolveFor(actor).containsOnlyText("1,000,000.96")
                && VALIDATION_MAXSALARY.resolveFor(actor).containsOnlyText("10,000,000.96")
        );
    }

    public static Currency currency(){
        return new Currency();
    }

}
