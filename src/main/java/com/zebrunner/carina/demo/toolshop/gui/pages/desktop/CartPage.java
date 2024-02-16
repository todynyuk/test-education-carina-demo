package com.zebrunner.carina.demo.toolshop.gui.pages.desktop;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(css = "span[class='product-title']")
    private ExtendedWebElement productTitleText;

    @FindBy(css = "button[data-test='proceed-1']")
    private ExtendedWebElement confirmButton;

    @FindBy(xpath = "//p[contains(text(),'already logged in')]")
    private ExtendedWebElement loggedInText;

    @FindBy(css = "button[data-test='proceed-2']")
    private ExtendedWebElement confirmSingInButton;

    @FindBy(css = "input[id='address']")
    private ExtendedWebElement addressInputField;

    @FindBy(css = "button[data-test='proceed-3']")
    private ExtendedWebElement confirmAddressButton;

    @FindBy(css = "select[id='payment-method']")
    private ExtendedWebElement paymentMethodMenu;

    @FindBy(css = "option[value='3: Credit Card']")
    private ExtendedWebElement paymentCreditCardOption;

    @FindBy(css = "input[id='account-name']")
    private ExtendedWebElement accountNameInputField;

    @FindBy(css = "input[id='account-number']")
    private ExtendedWebElement accountNumberInputField;

    @FindBy(css = "button[data-test='finish']")
    private ExtendedWebElement confirmFinishButton;

    @FindBy(css = "div[class='help-block']")
    private ExtendedWebElement successPaymentText;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitleText() {
        return productTitleText.getText();
    }

    @Override
    public void clickToCheckoutButton() {
        confirmButton.click();
    }

    @Override
    public boolean isElementPresent(){
        return loggedInText.isElementPresent();
    }

    @Override
    public void clickToConfirmSingInButton() {
        confirmSingInButton.click();
    }

    @Override
    public boolean isAddressInputPresent(){
        return addressInputField.isElementPresent();
    }

    @Override
    public void clickToConfirmAddressButton() {
        confirmAddressButton.click();
    }

    @Override
    public void fillPaymentMethod(String name, String number) {
        paymentMethodMenu.click();
        paymentCreditCardOption.click();
        accountNameInputField.type(name);
        accountNumberInputField.type(number);
        waitUntil(ExpectedConditions.elementToBeClickable(confirmFinishButton), 10);
        confirmFinishButton.click();
    }

    @Override
    public boolean isSuccessPaymentTextPresent(){
        return successPaymentText.isElementPresent();
    }
}
