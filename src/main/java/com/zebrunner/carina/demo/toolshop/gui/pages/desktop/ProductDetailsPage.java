package com.zebrunner.carina.demo.toolshop.gui.pages.desktop;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPage extends ProductDetailsPageBase {

    @FindBy(css = "h1[data-test='product-name']")
    private ExtendedWebElement productTitleText;

    @FindBy(css = "button[id='btn-add-to-cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(css = "span[data-test='cart-quantity']")
    private ExtendedWebElement cartCounter;

    @FindBy(css = "a[data-test='nav-cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//button[@id='btn-add-to-favorites']")
    private ExtendedWebElement addToFavorites;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addToCartButtonClick() {
        addToCartButton.click();
    }

    @Override
    public boolean isCartCounterPresent() {
        return cartCounter.isElementPresent();
    }

    @Override
    public String getTitleText() {
        return productTitleText.getText();
    }

    @Override
    public CartPageBase clickOnCartButton() {
        cartButton.click();
        return initPage(driver, CartPageBase.class);
    }

}
