package ru.mirapolis.lmslite47vr.demo;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;


public class LoginPageTest {

    LoginPage loginPage;
    private final String urlMirapolisLogin = "https://lmslite47vr.demo.mirapolis.ru/mira";

    @Before
    public void openPage() {
        loginPage = open(urlMirapolisLogin, LoginPage.class);
    }

    @Test
    public void authWithCorrectLoginAndPassword() {

        ProfilePage profilePage = open(urlMirapolisLogin, ProfilePage.class);

        loginPage.clickAndInputLogin("fominaelena")
                .clickAndInputPassword("1P73BP4Z")
                .clickShowPassword()
                .clickInputButton();
        profilePage.successfulAuth("Фомина Елена Сергеевна");
    }

    @Test
    public void checkPasswordTest() {
        loginPage.clickAndInputLogin("qwert")
                .clickAndInputPassword("asdfg")
                .clickShowPassword();

    }

    @Test
    public void viewFogotPassword() {

        FogotPasswordPage fogotPasswordPage = open(urlMirapolisLogin, FogotPasswordPage.class);
        loginPage.clickForgotPassword();

        fogotPasswordPage.viewPasswordRecovery();

    }
}
