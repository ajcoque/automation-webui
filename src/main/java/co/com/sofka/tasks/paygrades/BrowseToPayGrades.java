package co.com.sofka.tasks.paygrades;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hover;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.Task;

import static co.com.sofka.userinterfaces.paygrades.PayGrades.*;

public class BrowseToPayGrades implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ADMIN),
                Hover.over(ADMIN),

                Scroll.to(JOB),
                Hover.over(JOB),

                Scroll.to(PAYGRADES),
                Click.on(PAYGRADES)

        );
    }

    public static BrowseToPayGrades browseToPayGrades() {
        return new BrowseToPayGrades();
    }

}
