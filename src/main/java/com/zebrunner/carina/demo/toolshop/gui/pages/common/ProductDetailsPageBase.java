package com.zebrunner.carina.demo.toolshop.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailsPageBase extends AbstractPage {
    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addToCartButtonClick();

    public abstract boolean isCartCounterPresent();

    public abstract String getTitleText();

    public abstract CartPageBase clickOnCartButton();
}
