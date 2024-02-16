/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.toolshop.gui.pages.android;

import java.util.List;


import com.zebrunner.carina.demo.toolshop.gui.enums.ByCategoty;
import com.zebrunner.carina.demo.toolshop.gui.enums.SortDropdown;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;


import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//a[@data-test='filters']")
    private ExtendedWebElement webFilterButton;

    @FindBy(xpath = "//*[contains(@text,'Filters')]")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//span[@class='navbar-toggler-icon']")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(xpath = "//a[@data-test='nav-sign-in']")
    private ExtendedWebElement singInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickOnLoginButton() {
        return null;
    }

    @Override
    public void searchForProduct(String query) {
    }

    @Override
    public List<String> getProductTitles() {
        return null;
    }

    @Override
    public void getProductTitleText(String name) {

    }

    @Override
    public void clickOnDropdownMenu() {
    }

    @Override
    public void sortDropdownMenu(SortDropdown sortDropdown) {
    }

    @Override
    public boolean isProductsSortedFromLowToHighPrice() {
        return false;
    }

    @Override
    public void setCheckboxByCategory(ByCategoty byCategory) {
    }

    @Override
    public boolean isChosenNameCorrect(String name) {
        return false;
    }

    @Override
    public ProductDetailsPageBase clickOnProductPage(int index) {
        return null;
    }

    @Override
    public boolean isFilterButtonPresent() {
        return webFilterButton.isElementPresent();
    }

    @Override
    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }

    @Override
    public LoginPageBase clickOnSingInButton() {
        singInButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }
}
