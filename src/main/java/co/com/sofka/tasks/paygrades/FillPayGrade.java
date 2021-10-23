package co.com.sofka.tasks.paygrades;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.Task;

import static co.com.sofka.userinterfaces.paygrades.PayGrades.*;

public class FillPayGrade implements Task{

    private String name;

    public FillPayGrade usingName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Scroll.to(ADD),
                Click.on(ADD),

                Scroll.to(NAME_GRADE),
                Enter.theValue(this.name).into(NAME_GRADE),

                Scroll.to(SAVE),
                Click.on(SAVE)


        );

    }

    public static FillPayGrade fillPayGrade(){
        return new FillPayGrade();
    }

}
