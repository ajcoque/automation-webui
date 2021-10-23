package co.com.sofka.questions.users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.sofka.userinterfaces.users.Users.VALIDATION_USERNAME;

public class Users implements Question<Boolean> {

    private String username;

    public Users wasFilledWithUserName(String username) {
        this.username = username;
        return this;
    }

    public Users is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (VALIDATION_USERNAME.resolveFor(actor).containsOnlyText(username));
    }

    public static Users users(){
        return new Users();
    }
}
