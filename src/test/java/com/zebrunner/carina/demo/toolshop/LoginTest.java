package com.zebrunner.carina.demo.toolshop;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.AccountPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.LoginPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest implements IAbstractTest {
    @Test(description = "User can login")
    public void LoginTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LoginPageBase loginPage = homePage.clickOnLoginButton();
        AccountPageBase accountPage = loginPage.login("henry555@gmail.com", "henry*75757");
        Assert.assertTrue(accountPage.isFavoritesButtonPresent(), "Favorites button isn`t presented");
        Assert.assertTrue(accountPage.isProfileButtonPresent(), "Profile button isn`t presented");
        Assert.assertTrue(accountPage.isInvoicesButtonPresent(), "Invoices button isn`t presented");
        Assert.assertTrue(accountPage.isMessagesButtonPresent(), "Messages button isn`t presented");

    }
}
