package com.zebrunner.carina.demo.toolshop;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.ProductDetailsPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest implements IAbstractTest {
    final int INDEX_ONE = 1;

    @Test(description = "User can add products to cart")
    public void addProductToCartTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        ProductDetailsPageBase detailsPage = homePage.clickOnProductPage(INDEX_ONE);
        detailsPage.addToCartButtonClick();
        Assert.assertTrue(detailsPage.isCartCounterPresent(), " Counter isn`t presented");
        String titleText = detailsPage.getTitleText();
        CartPageBase cardPage = detailsPage.clickOnCartButton();
        Assert.assertTrue(cardPage.getTitleText().contains(titleText), " Card title text is not contains" +
                " product title text");
    }
}
