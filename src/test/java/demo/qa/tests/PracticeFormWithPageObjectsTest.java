package demo.qa.tests;

import demo.qa.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

import static demo.qa.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormWithPageObjectsTest extends TestBase{

    PracticeFormPage practiceFormPage = new PracticeFormPage();

//    Cloned repository
    @Test
    void fillFormTest() {

        step("Fill form (all fields)", () -> {
                    practiceFormPage.openPage()
                            .setName(firstUserFirstName, firstUserLastName)
                            .setMail(firstUserMail)
                            .setGender(firstUserGender)
                            .setNumber(firstUserNumber)
                            .setBirthDate(firstUserDayOfMonth, firstUserMonth, firstUserYear)
                            .setSubject(firstUserSubject)
                            .setHobby(firstUserHobby)
                            .uploadFile(userFile)
                            .setCurrentAddress(firstUserAddress)
                            .setStateAndCity(firstUserState, firstUserCity)
                            .submitForm();
        });

        step("Check modal dialog (all fields)", () -> {
            practiceFormPage.checkTableAppearance()
                    .checkValueInTable("Student Name", firstUserFirstName + " " + firstUserLastName)
                    .checkValueInTable("Student Email", firstUserMail)
                    .checkValueInTable("Gender", firstUserGender)
                    .checkValueInTable("Mobile", firstUserNumber)
                    .checkValueInTable("Date of Birth", firstUserDayOfMonth + " " + firstUserMonth + "," + firstUserYear)
                    .checkValueInTable("Subjects", firstUserSubject)
                    .checkValueInTable("Hobbies", firstUserHobby)
                    .checkValueInTable("Picture", "cat.jpg")
                    .checkValueInTable("Address", firstUserAddress)
                    .checkValueInTable("State and City", firstUserState + " " + firstUserCity);
        });
    }

    @Test
    void fillFormWithMinimumDataTest() {

        step("Fill form (minimum data)", () -> {
                    practiceFormPage.openPage()
                            .setName(secondUserFirstName, secondUserLastName)
                            .setGender(secondUserGender)
                            .setNumber(secondUserNumber)
                            .submitForm();
        });

        step("Check modal dialog (minimum data)", () -> {
            practiceFormPage.checkTableAppearance()
                    .checkValueInTable("Student Name", secondUserFirstName + " " + secondUserLastName)
                    .checkValueInTable("Gender", secondUserGender)
                    .checkValueInTable("Mobile", secondUserNumber);
        });
    }
}
