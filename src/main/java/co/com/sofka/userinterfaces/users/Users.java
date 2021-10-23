package co.com.sofka.userinterfaces.users;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class Users extends PageObject {

    public static final Target SEARCH_USERNAME = Target
            .the("searchSystemUser_userName")
            .located(id("searchSystemUser_userName"));

    public static final Target SEARCH = Target
            .the("searchBtn")
            .located(id("searchBtn"));

    //For fill elements.
    public static final Target ADMIN = Target
            .the("Admin")
            .located(id("menu_admin_viewAdminModule"));

    public static final Target USER_MANAGEMENT = Target
            .the("User Management")
            .located(id("menu_admin_UserManagement"));

    public static final Target USERS = Target
            .the("Users")
            .located(id("menu_admin_viewSystemUsers"));


    //For validations.
    public static final Target VALIDATION_USERNAME = Target
            .the("Result Username")
            .located(xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a"));

}
