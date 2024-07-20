package demo.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoksFullfillFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browser = "google";
    }

    @Test
    void FullFillForm() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Elon");
        $("[id=lastName]").setValue("Beluchi");
        $("#userEmail").setValue("examplemail@gmail.com");
        $$(".custom-control-label").get(1).shouldHave(text("Female")).click();
        $("#userNumber").setValue("89024499555");

        // Найдите и кликните по полю ввода даты
        $("[id=dateOfBirthInput]").click();
        // Убедитесь, что календарь открылся
        $(".react-datepicker__month-container").shouldBe(visible);
        // Выберите месяц и год, если необходимо
        $(".react-datepicker__month-select").selectOption("March"); // Замените на нужный месяц
        $(".react-datepicker__year-select").selectOption("2002"); // Замените на нужный год
        // Выберите день
        $$(".react-datepicker__day").findBy(text("19")).click();
        // Проверьте, что дата установлена правильно
        $("[id=dateOfBirthInput]").shouldHave(value("19 Mar 2002"));
        $("#uploadPicture").uploadFromClasspath("name.jpeg");

        $$(".custom-control-label").get(3).shouldHave(text("Sports")).click();

        //select the window "State"
        $("[id=state]").click();
        //Check that the window is open
        $("#state").shouldBe(visible);
        //Choose the certain State
        $("#state").selectOption("NCR");
        //$$("#state").findBy(text("NCR"));
        $("#state").shouldHave(value("NCR"));

        //select the window "City"
        $("#city").click();
        //Check that the window is open
        $("#city").shouldBe(visible);
        //Choose the certain City
        $("#state").selectOption("Delhi");
        $("#city").shouldHave(value("Delhi"));

        $("#submit").click();
        System.out.println("Test is done");
        $("#submit").click();



    }



}