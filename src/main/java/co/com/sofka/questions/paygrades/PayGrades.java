package co.com.sofka.questions.paygrades;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.paygrades.PayGrades.VALIDATION_LINKTEXT_GRADE;

public class PayGrades implements Question<Boolean> {

    private String name;

    public PayGrades wasFilledWithName(String name) {
        this.name = name;
        return this;
    }

    public PayGrades is() {
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (VALIDATION_LINKTEXT_GRADE.resolveFor(actor).containsOnlyText(name));
    }

    public static PayGrades payGrades() {
        return new PayGrades();
    }
}
