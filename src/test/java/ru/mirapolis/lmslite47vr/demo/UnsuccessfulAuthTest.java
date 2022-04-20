package ru.mirapolis.lmslite47vr.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class UnsuccessfulAuthTest {
    private final String login;
    private final String password;

    @Parameterized.Parameters
    public static Object[][] getNewCourierData() {
        return new Object[][]{
                {null, "qwerty"},
                {"qwerty", null},
                {null, null},
                {"qwerty", "asdfgh"},
        };
    }

    public UnsuccessfulAuthTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private final String urlMirapolisLogin = "https://lmslite47vr.demo.mirapolis.ru/mira";

    @Test
    public void authWithIncorrectLoginAndPassword() {
        LoginPage loginPage = open(urlMirapolisLogin, LoginPage.class);

        loginPage.clickAndInputLogin(login)
                .clickAndInputPassword(password)
                .clickInputButton();
        assertTrue(switchTo().alert().getText().contains("Неверные данные для авторизации"));
        switchTo().alert().accept();

    }
}
