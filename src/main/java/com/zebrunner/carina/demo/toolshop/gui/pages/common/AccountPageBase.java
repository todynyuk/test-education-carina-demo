package com.zebrunner.carina.demo.toolshop.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AccountPageBase extends AbstractPage {

    public AccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isFavoritesButtonPresent();

    public abstract boolean isProfileButtonPresent();

    public abstract boolean isInvoicesButtonPresent();

    public abstract boolean isMessagesButtonPresent();

    public abstract HomePageBase clickOnHomePage();
}
