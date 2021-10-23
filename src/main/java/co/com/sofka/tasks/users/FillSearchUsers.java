package co.com.sofka.tasks.users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.users.Users.SEARCH;
import static co.com.sofka.userinterfaces.users.Users.SEARCH_USERNAME;

public class FillSearchUsers implements Task {
    private String username;

    public FillSearchUsers usingUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SEARCH_USERNAME),
                Enter.theValue(this.username).into(SEARCH_USERNAME),

                Scroll.to(SEARCH),
                Click.on(SEARCH)

        );

    }

    public static FillSearchUsers fillSearchUsers() {
        return new FillSearchUsers();
    }
}
