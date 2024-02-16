package com.zebrunner.carina.demo.toolshop;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.toolshop.gui.enums.ByCategoty;
import com.zebrunner.carina.demo.toolshop.gui.enums.SortDropdown;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;

public class HomePageTest implements IAbstractTest {

    @Test(description = "User can search product and check if products results are not empty.")
    public void productSearchTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.searchForProduct("Hammer");
        List<String> productTitles = homePage.getProductTitles();
        Assert.assertFalse(productTitles.isEmpty(), "Product search results are empty.");
        homePage.getProductTitleText("hammer");
    }

    @Test(description = "User can sort dropdown menu and check if products are sorted.")
    public void sortLowToHighTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.clickOnDropdownMenu();
        homePage.sortDropdownMenu(SortDropdown.LOW_TO_HIGH);
        Assert.assertTrue(homePage.isProductsSortedFromLowToHighPrice(), "Product price are not sorted");
    }

    @Test(description = "User can use and check checkbox filters.")
    public void checkboxFilterTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.setCheckboxByCategory(ByCategoty.PLIERS);
        Assert.assertTrue(homePage.isChosenNameCorrect("Pliers"), "Product filter are not contains text");
    }
}
