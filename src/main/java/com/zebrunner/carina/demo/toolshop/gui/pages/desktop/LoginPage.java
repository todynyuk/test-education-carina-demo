package com.zebrunner.carina.demo.toolshop.gui.pages.desktop;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.AccountPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(css = "input[data-test='email']")
    private ExtendedWebElement emailInputField;

    @FindBy(css = "input[data-test='password']")
    private ExtendedWebElement passwordInputField;

    @FindBy(css = "input[data-test='login-submit']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountPageBase login(String email, String password) {
        emailInputField.type(email);
        passwordInputField.type(password);
        loginButton.click();
        return initPage(driver, AccountPageBase.class);
    }
}
