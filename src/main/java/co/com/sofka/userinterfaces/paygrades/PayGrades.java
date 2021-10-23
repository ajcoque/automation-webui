package co.com.sofka.userinterfaces.paygrades;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.*;

public class PayGrades extends PageObject {

    public static final Target ADD = Target
            .the("Add")
            .located(id("btnAdd"));

    public static final Target NAME_GRADE = Target
            .the("name grade")
            .located(id("payGrade_name"));

    public static final Target SAVE = Target
            .the("Save")
            .located(id("btnSave"));


    //For fill elements.
    public static final Target ADMIN = Target
            .the("Admin")
            .located(id("menu_admin_viewAdminModule"));

    public static final Target JOB = Target
            .the("Job")
            .located(id("menu_admin_Job"));

    public static final Target PAYGRADES = Target
            .the("Pay Grades")
            .located(id("menu_admin_viewPayGrades"));


    //For validations.
    public static final Target VALIDATION_LINKTEXT_GRADE = Target
            .the("Validation linkText Grade B")
            .located(linkText("Grade B"));

    public static final Target VALIDATION_LINKTEXT_TYPE_CURRENCY = Target
            .the("Validation linkText Colombian Peso")
            .located(linkText("Colombian Peso"));


}
