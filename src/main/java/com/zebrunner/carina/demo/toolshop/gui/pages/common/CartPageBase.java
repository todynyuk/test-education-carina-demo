package com.zebrunner.carina.demo.toolshop.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {
    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTitleText();

    public abstract void clickToCheckoutButton();

    public abstract boolean isElementPresent();

    public abstract void clickToConfirmSingInButton();

    public abstract boolean isAddressInputPresent();

    public abstract void clickToConfirmAddressButton();

    public abstract void fillPaymentMethod(String name, String number);

    public abstract boolean isSuccessPaymentTextPresent();
}
