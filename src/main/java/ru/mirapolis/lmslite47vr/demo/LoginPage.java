package ru.mirapolis.lmslite47vr.demo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.page;


public class LoginPage {

    //локатор логотипа Mirapolis, страница авторизации
    @FindBy(how = How.XPATH, using = ".//img[@src='Logo/Login']")
    private SelenideElement mainAuthButton;

    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//button[@class = 'mira-widget-login-button mira-default-login-page-button-submit']")
    private SelenideElement inputButton;

    //локатор кнопки Посмотреть пароль
    @FindBy(how = How.ID, using = "show_password")
    private SelenideElement showPassword;

    //локатор поля ввода логина
    @FindBy(how = How.XPATH, using = ".//input[@placeholder = 'Введите ваш логин']")
    private SelenideElement loginField;

    //локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@placeholder = 'Введите ваш пароль']")
    private SelenideElement passwordField;

    //локатор кнопки "Забыли пароль?"
    @FindBy(how = How.XPATH, using = ".//table[@class = 'links-container']/tbody/tr/td/a/div")
    private SelenideElement forgotPassword;


    //метод клика по полю ввода логина
    public LoginPage clickAndInputLogin(String login) {
        loginField.click();
        loginField.setValue(login);
        return page(LoginPage.class);
    }

    //метод клика по полю ввода пароля
    public LoginPage clickAndInputPassword(String password) {
        passwordField.click();
        passwordField.setValue(password);
        return page(LoginPage.class);
    }

    //метод клика по кнопке Посмотреть пароль и проверка типа локатора
    public LoginPage clickShowPassword() {
        showPassword.click();
        Assert.assertEquals(passwordField.getAttribute("type"), "text");
        showPassword.click();
        Assert.assertEquals(passwordField.getAttribute("type"), "password");
        return page(LoginPage.class);
    }

    //метод клика по кнопке Войти
    public ProfilePage clickInputButton() {
        inputButton.click();
        return page(ProfilePage.class);
    }

    //метод клика по кнопке "Забыли пароль?"
    public FogotPasswordPage clickForgotPassword() {
        forgotPassword.click();
        return page(FogotPasswordPage.class);
    }


}
