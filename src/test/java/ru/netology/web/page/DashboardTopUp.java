package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardTopUp {
    private SelenideElement sumField = $("[class=input__control]");
    private SelenideElement cardField = $("[type=tel]");
    private SelenideElement replenishButton = $("[class=button__text]");
    private SelenideElement heading = $("[data-test-id=dashboard]");

    public DashboardTopUp() {
        heading.shouldBe(visible);
    }

    public DashboardPage replenish (String sum, DataHelper.CardsAccount cardsAccount, int number) {
        sumField.setValue(sum);
        if (number != 1) {
            cardField.setValue(cardsAccount.getString1());
        } else {
            cardField.setValue(cardsAccount.getString2());
        }
        replenishButton.click();
        return new DashboardPage();
    }

}
