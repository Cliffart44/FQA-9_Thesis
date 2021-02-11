package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CreditPage {
    private static SelenideElement heading = $$(".heading_size_m").find(text("Кредит"));
    private static SelenideElement cardNumberField = $(".input [maxlength='19']");
    private static SelenideElement cardNumberFieldErrorMessage = $x("//div[1]/span/span/span[3]");
    private static SelenideElement monthField = $x("//div[2]/span/span[1]/span/span/span[2]/input");
    private static SelenideElement monthFieldErrorMessage = $x("//div[2]/span/span[1]/span/span/span[3]");
    private static SelenideElement yearField = $x("//div[2]/span/span[2]/span/span/span[2]/input");
    private static SelenideElement yearFieldErrorMessage = $x("//div[2]/span/span[2]/span/span/span[3]");
    private static SelenideElement ownerField = $x("//div[3]/span/span[1]/span/span/span[2]/input");
    private static SelenideElement ownerFieldErrorMessage = $$(".form-field .input__sub").find(text("Поле"));
    private static SelenideElement cvcCvvField = $("input[placeholder='999']");
    private static SelenideElement cvcCvvFieldErrorMessage = $x("//div[3]/span/span[2]/span/span/span[3]");
    private static SelenideElement proceedButton = $(".form-field .button");
    private static SelenideElement succeedNotification = $(".icon_name_ok");
    private static SelenideElement succeedNotificationTitle = $$(".notification__title").find(text("Успешно"));
    private static SelenideElement succeedMessage = $$(".notification__content").findBy(text("одобрена"));
    private static SelenideElement errorNotification = $(".icon_name_error");
    private static SelenideElement errorNotificationTitle = $$(".notification__title").find(text("Ошибка"));
    private static SelenideElement errorMessage = $$(".notification__content").find(text("отказал"));

    public CreditPage() {
        heading.shouldBe(visible);
    }

    private final int delay = 11;

    private void request(DataHelper.RequiredFields fields) {
        cardNumberField.setValue(fields.getCardNumber());
        monthField.setValue(fields.getMonth());
        yearField.setValue(fields.getYear());
        ownerField.setValue(fields.getOwner());
        cvcCvvField.setValue(fields.getCvcCvv());
        proceedButton.click();
    }

    public void approved(DataHelper.RequiredFields fields) {
        request(fields);
        succeedNotification.shouldBe(visible, Duration.ofSeconds(delay));
        succeedNotificationTitle.shouldBe(visible, Duration.ofSeconds(delay)).shouldHave(exactOwnText("Успешно"));
        succeedMessage.shouldBe(visible, Duration.ofSeconds(delay)).shouldHave(exactOwnText("Операция одобрена Банком."));
    }

    public void declinedWithValidInput(DataHelper.RequiredFields fields) {
        request(fields);
        errorNotification.shouldBe(visible, Duration.ofSeconds(delay));
        errorNotificationTitle.shouldBe(visible, Duration.ofSeconds(delay)).shouldHave(exactOwnText("Ошибка"));
        errorMessage.shouldBe(visible, Duration.ofSeconds(delay)).shouldHave(exactOwnText("Банк отказал в проведении операции."));
    }

    public void declinedWithEmptyFields() {
        proceedButton.click();
        cardNumberFieldErrorMessage.shouldBe(visible).shouldHave(exactOwnText("Неверный формат"));
        monthFieldErrorMessage.shouldBe(visible).shouldHave(exactOwnText("Неверный формат"));
        yearFieldErrorMessage.shouldBe(visible).shouldHave(exactOwnText("Неверный формат"));
        ownerFieldErrorMessage.shouldBe(visible).shouldHave(exactOwnText("Поле обязательно для заполнения"));
        cvcCvvFieldErrorMessage.shouldBe(visible).shouldHave(exactOwnText("Неверный формат"));
    }

    public void declinedWithInvalidCard(DataHelper.RequiredFields fields) {
        request(fields);
        cardNumberFieldErrorMessage.shouldBe(visible).shouldHave(exactOwnText("Номер карты введён неверно"));
    }

    public void declinedWithInvalidOwner(DataHelper.RequiredFields fields) {
        request(fields);
        ownerFieldErrorMessage.shouldBe(visible).shouldHave(exactOwnText("Поле обязательно для заполнения"));
    }
}
