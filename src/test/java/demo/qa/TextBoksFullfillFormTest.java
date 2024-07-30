package demo.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoksFullfillFormTest {

    @BeforeAll
    static void setupLink() {
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browser = "google";
        // Настройки Selenide
        // Configuration.browserSize = "1920x1080";
        // Configuration.holdBrowserOpen = true;
        // Configuration.browser = "chrome";
        // Configuration.timeout = 60000; // Таймаут в миллисекундах (например, 60 секунд)
        // Configuration.pageLoadTimeout = 60000; // Таймаут загрузки страницы в миллисекундах (например, 60 секунд)
    }

    @Test
    void FullFillForm() {
        open("/automation-practice-form");
        // String name(любое слово или ник) = "Elon"; создание переменной для оптимизации кода
        executeJavaScript ("$(' footer'). remove()");
        executeJavaScript ("$('#fixedban'). remove()");
        $("[id=firstName]").setValue("Elon");
        $("[id=lastName]").setValue("Beluchi");
        $("#userEmail").setValue("examplemail@gmail.com");
        $$(".custom-control-label").get(1).shouldHave(text("Female")).click();
        $("#userNumber").setValue("89024499555");

        // Найдите и кликните по полю ввода даты
        $("[id=dateOfBirthInput]").click();
        // Убедитесь, что календарь открылся
        $(".react-datepicker__month-container").scrollIntoView(false).shouldBe(visible);
        // Выберите месяц и год, если необходимо
        $(".react-datepicker__month-select").selectOption("March"); // Замените на нужный месяц
        $(".react-datepicker__year-select").selectOption("2002"); // Замените на нужный год
        // Выберите день
        $$(".react-datepicker__day").findBy(text("19")).scrollIntoView(true).click();
        // Проверьте, что дата установлена правильно
        $("[id=dateOfBirthInput]").shouldHave(value("19 Mar 2002"));

        $("#uploadPicture").uploadFromClasspath("name.jpeg");

        $$(".custom-control-label").get(3).scrollIntoView(false).shouldHave(text("Sports")).click();

        //select the window "State"
        $("#state").scrollIntoView(false).shouldBe(visible).click();
        //Check that the window is open
        //$("#state").shouldBe(visible);
        //Choose the certain State
        $(".css-26l3qy-menu").shouldBe(visible);
        $("#react-select-3-option-0").click();
        $("#state").shouldHave(text("NCR"));

        //select the window "City"
        $("#city").shouldBe(visible).click();
        //Check that the window is open

        //Choose the certain City
        $(".css-26l3qy-menu").shouldBe(visible);
        $$(".css-26l3qy-menu").findBy(text("Delhi"));
        $("#city").shouldHave(text("Delhi"));

        $("#submit").click();
        System.out.println("Test is done");



    }



}