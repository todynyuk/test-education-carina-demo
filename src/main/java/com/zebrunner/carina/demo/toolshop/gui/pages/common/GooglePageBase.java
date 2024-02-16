package com.zebrunner.carina.demo.toolshop.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GooglePageBase extends AbstractPage {
    public GooglePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void openBrowser();

    public abstract HomePageBase googleSearch(String url);

    public abstract LoginPageBase googleSearchLogin(String url);

    public abstract NewTabPageBase showAllTab();

    public abstract boolean isSearchInputPresent();

    public abstract HomePageBase goToHomePage();
}
