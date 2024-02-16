package com.zebrunner.carina.demo.toolshop;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.GooglePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.NewTabPageBase;
import com.zebrunner.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchingOfContextsTest implements IAbstractTest, IMobileUtils {

    @Test(description = "Switching of context from web to native")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void switchingOfContextsTest() {
        MobileContextUtils contextHelper = new MobileContextUtils();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isFilterButtonPresent(), "Filter button isn't presented");
        GooglePageBase googlePage = initPage(getDriver(), GooglePageBase.class);
        contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
        NewTabPageBase newTabPageBase = googlePage.showAllTab();
        googlePage = newTabPageBase.newTab();
        Assert.assertTrue(googlePage.isSearchInputPresent(), "Search input isn't presented");
        googlePage.showAllTab();
        homePage = googlePage.goToHomePage();
        contextHelper.switchMobileContext(MobileContextUtils.View.WEB_CHROMIUM);
        Assert.assertTrue(homePage.isFilterButtonPresent(), "Filter button isn't presented");
    }
}
