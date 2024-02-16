package com.zebrunner.carina.demo.toolshop.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NewTabPageBase extends AbstractPage {
    public NewTabPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract GooglePageBase newTab();
}
