package ru.mirapolis.lmslite47vr.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class FogotPasswordPage {
    //локатор страницы "Забыли пароль?"
    @FindBy(how = How.CLASS_NAME, using = "mira-page-forgot-password-form")
    private SelenideElement forgotPasswordPage;

    //локатор текста "Восстановление пароля"
    @FindBy(how = How.CLASS_NAME, using = "info-title")
    private SelenideElement passwordRecovery;


    //метод проверки того, что появилась страница восстановления пароля
    public void viewPasswordRecovery() {
        Assert.assertTrue(forgotPasswordPage.isDisplayed());
        passwordRecovery.shouldHave(Condition.text("Восстановление пароля"));
    }
}
