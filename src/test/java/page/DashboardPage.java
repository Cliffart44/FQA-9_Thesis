package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private static SelenideElement heading = $(".heading_size_l");
    private static SelenideElement paymentButton = $$(".button .button__text").find(text("Купить"));
    private static SelenideElement creditButton = $$(".button .button__text").find(text("Купить в кредит"));

    public DashboardPage() {
        heading.shouldBe(visible).shouldHave(text("Путешествие дня"));
    }

    public PaymentPage goToPaymentPage(){
        paymentButton.click();
        return new PaymentPage();
    }

    public CreditPage goToCreditPage(){
        creditButton.click();
        return new CreditPage();
    }
}
