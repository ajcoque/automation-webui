package co.com.sofka.tasks.users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hover;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.Task;

import static co.com.sofka.userinterfaces.users.Users.*;

public class BrowseToUsers implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ADMIN),
                Hover.over(ADMIN),

                Scroll.to(USER_MANAGEMENT),
                Hover.over(USER_MANAGEMENT),

                Scroll.to(USERS),
                Click.on(USERS)

        );
    }

    public static BrowseToUsers browseToUsers() {
        return new BrowseToUsers();
    }
}
