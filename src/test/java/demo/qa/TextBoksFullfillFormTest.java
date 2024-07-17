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
        //$("#gender-radio-1").click();
        $("#userNumber").setValue("888988889");

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
        System.out.println();



    }



}