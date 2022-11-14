package demo.qa.pages;

import com.codeborne.selenide.SelenideElement;
import demo.qa.pages.components.AfterRegistrationComponent;
import demo.qa.pages.components.CalendarComponent;
import demo.qa.pages.components.DropdownComponent;
import demo.qa.pages.components.UploadFileComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final AfterRegistrationComponent afterRegistrationComponent = new AfterRegistrationComponent();
    private final DropdownComponent dropdownComponent = new DropdownComponent();
    private final UploadFileComponent uploadFileComponent = new UploadFileComponent();

    //    Elements
    private final SelenideElement
            firstnameInput = $("#firstName");
    private final SelenideElement lastnameInput = $("#lastName");

    //    Actions, fill form
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;

    }

    public PracticeFormPage setName(String firstName, String lastName) {
        firstnameInput.setValue(firstName);
        lastnameInput.setValue(lastName);
        return this;

    }

    public PracticeFormPage setMail(String mail) {
        $("#userEmail").setValue(mail);
        return this;

    }

    public PracticeFormPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;

    }

    public PracticeFormPage setNumber(String number) {
        $("#userNumber").setValue(number);
        return this;

    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
//    Календарь вынесен в отдельный компонент, т.к. может много где использоваться
        calendarComponent.setDate(day, month, year);
        return this;

    }

    public PracticeFormPage setSubject(String subject) {
        dropdownComponent.setSubject(subject);
        return this;

    }

    public PracticeFormPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;

    }

    public PracticeFormPage uploadFile(String fileName) {
        uploadFileComponent.uploadFileFromClasspath(fileName);
        return this;

    }

    public PracticeFormPage setCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;

    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        dropdownComponent.setState(state);
        dropdownComponent.setCity(city);
        return this;

    }

    public void submitForm() {
        $("#submit").click();

    }

    //    Actions, check results
    public PracticeFormPage checkTableAppearance() {
        afterRegistrationComponent.checkTableAppearance();
        return this;

    }

    public PracticeFormPage checkValueInTable(String key, String value) {
        afterRegistrationComponent.checkValue(key, value);
        return this;

    }

}
