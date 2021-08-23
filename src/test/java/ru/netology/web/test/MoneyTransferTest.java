package ru.netology.web.test;

import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPageV3;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {
  @Test
  void shouldTransferMoneyBetweenOwnCardsV3() {
    var loginPage = open("http://localhost:9999", LoginPageV3.class);
    var authInfo = DataHelper.getAuthInfo();
    var verificationPage = loginPage.validLogin(authInfo);
    var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    verificationPage.validVerify(verificationCode);
    var cardsAccount = DataHelper.getCardsAccount();
    var clientCards = new DashboardPage();
    int firstBalance = clientCards.getFirstCardBalance();
    int secondCardBalance = clientCards.getSecondCardBalance();
    int difference = 200;
    var replenishThis = clientCards.replenishFirst();
    replenishThis.replenish(Integer.toString(difference), cardsAccount, 1);
    assertEquals(firstBalance + difference, clientCards.getFirstCardBalance());
    assertEquals(secondCardBalance - difference, clientCards.getSecondCardBalance());

  }

}



