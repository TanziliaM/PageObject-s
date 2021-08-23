package ru.netology.web.data;

import lombok.Value;

public class DataHelper {
  private DataHelper() {
  }

  @Value
  public static class CardsAccount {
    private String string1;
    private String string2;
  }

  public static CardsAccount getCardsAccount() {
    return new CardsAccount("5559 0000 0000 0001", "5559 0000 0000 0002");
  }

  @Value
  public static class AuthInfo {
    private String login;
    private String password;
  }

  public static AuthInfo getAuthInfo() {
    return new AuthInfo("vasya", "qwerty123");
  }

  public static AuthInfo getOtherAuthInfo(AuthInfo original) {
    return new AuthInfo("petya", "123qwerty");
  }

  @Value
  public static class VerificationCode {
    private String code;
  }

  public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
    return new VerificationCode("12345");
  }


  @Value
  public static class TopUpAccount {
    private String amount;
    private String from;
    private String to;
  }

  public static TopUpAccount getTopUpAccount(TopUpAccount topUpAccount) {
    return new TopUpAccount("200", "5559 0000 0000 0001", "**** **** **** 0001");
  }
}

