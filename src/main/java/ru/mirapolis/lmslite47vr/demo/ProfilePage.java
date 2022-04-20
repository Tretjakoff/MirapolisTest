package ru.mirapolis.lmslite47vr.demo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.testng.AssertJUnit.assertEquals;

public class ProfilePage {
    //локатор текста "Главная страница"
    @FindBy(how = How.CLASS_NAME, using = "mira-label-text mira_label_text")
    private SelenideElement mainPageText;

    //локатор текста "Главная страница"
    @FindBy(how = How.CLASS_NAME, using = "avatar-full-name")
    private SelenideElement fullName;

    //метод проверки того, что авторизация прошла успешно
    public void successfulAuth(String fullNameProfile) {
        assertEquals(fullNameProfile, fullName.text());
    }
}
