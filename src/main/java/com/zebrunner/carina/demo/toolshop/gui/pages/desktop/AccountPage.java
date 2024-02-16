package com.zebrunner.carina.demo.toolshop.gui.pages.desktop;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.AccountPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountPageBase.class)
public class AccountPage extends AccountPageBase {

    @FindBy(css = "a[data-test='nav-favorites']")
    private ExtendedWebElement myFavoritesButton;

    @FindBy(css = "a[data-test='nav-profile']")
    private ExtendedWebElement profileButton;

    @FindBy(css = "a[data-test='nav-invoices'")
    private ExtendedWebElement invoicesButton;

    @FindBy(css = "a[data-test='nav-messages']")
    private ExtendedWebElement messagesButton;

    @FindBy(css = "a[data-test='nav-home']")
    private ExtendedWebElement homeButton;

    @FindBy(css = "a[id='user-menu']")
    private ExtendedWebElement userMenu;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFavoritesButtonPresent() {
        return myFavoritesButton.isElementPresent(2000);
    }

    @Override
    public boolean isProfileButtonPresent() {
        return profileButton.isElementPresent(2000);
    }

    @Override
    public boolean isInvoicesButtonPresent() {
        return invoicesButton.isElementPresent(2000);
    }

    @Override
    public boolean isMessagesButtonPresent() {
        return messagesButton.isElementPresent(2000);
    }

    @Override
    public HomePageBase clickOnHomePage() {
        homeButton.click();
        return initPage(driver, HomePageBase.class);
    }
}
