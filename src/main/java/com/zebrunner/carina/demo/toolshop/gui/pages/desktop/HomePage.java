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
package com.zebrunner.carina.demo.toolshop.gui.pages.desktop;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.zebrunner.carina.demo.toolshop.gui.enums.ByCategoty;
import com.zebrunner.carina.demo.toolshop.gui.enums.SortDropdown;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.ProductDetailsPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = "input[data-test='search-query']")
    private ExtendedWebElement searchInputField;

    @FindBy(css = "button[data-test='search-submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//h5[@data-test='product-name']")
    private List<ExtendedWebElement> productsNameList;

    @FindBy(xpath = "//h3[contains(text(),'Searched for')]")
    private ExtendedWebElement searchTitle;

    @FindBy(xpath = "//h4[contains(text(),'By category')]")
    private ExtendedWebElement byCategoryText;

    @FindBy(xpath = "//h4[contains(text(),'By brand:')]")
    private ExtendedWebElement byBrandText;

    @FindBy(css = "select[data-test='sort']")
    private ExtendedWebElement dropdownMenu;

    @FindBy(xpath = "//option[contains(.,'%s')]")
    private ExtendedWebElement universalDropdownMenu;

    @FindBy(xpath = "//label[contains(text(),'%s')]")
    private ExtendedWebElement checkboxByCategory;

    @FindBy(css = "span[data-test='product-price']")
    private List<ExtendedWebElement> productsPriceList;

    @FindBy(css = "a[data-test='nav-sign-in']")
    private ExtendedWebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickOnLoginButton() {
        signInButton.click();
        return initPage(driver, LoginPageBase.class);
    }

    @Override
    public void searchForProduct(String query) {
        searchInputField.type(query);
        searchButton.click();
    }

    @Override
    public List<String> getProductTitles() {
        List<String> titles = new ArrayList<>();
        for (ExtendedWebElement product : productsNameList) {
            titles.add(product.getText());
        }
        return titles;
    }

    @Override
    public void getProductTitleText(String name) {
        List<String> productNameListTexts = getProductTitles();
        List<String> filteredList = productNameListTexts.stream()
                .filter(s -> s.toLowerCase().contains(name))
                .collect(Collectors.toList());
        filteredList.forEach(System.out::println);
    }

    @Override
    public void clickOnDropdownMenu() {
        dropdownMenu.click();
    }

    @Override
    public void sortDropdownMenu(SortDropdown sortDropdown) {
        universalDropdownMenu.format(sortDropdown.getSortType()).click();
    }

    @Override
    public boolean isProductsSortedFromLowToHighPrice() {
        List<Double> priceList = new ArrayList<>();
        for (WebElement element : productsPriceList) {
            priceList.add(Double.parseDouble(element.getText().replace("$", "")));
        }
        for (int i = 0; i < priceList.size() - 1; i++) {
            if (priceList.get(i) <= priceList.get(i + 1)) {
                LOGGER.info("Sort from low to high price: [" + priceList.get(i) + "] [" + priceList.get(i + 1) + "]");
            } else if (priceList.get(i) > priceList.get(i + 1)) {
                LOGGER.error("Sort from low to high price: [" + priceList.get(i) + "] [" + priceList.get(i + 1) + "]");
                return false;
            }
        }
        return true;
    }

    @Override
    public void setCheckboxByCategory(ByCategoty byCategory) {
        checkboxByCategory.format(byCategory.getCategory()).click();

    }

    @Override
    public boolean isChosenNameCorrect(String name) {
        return getProductTitles().contains(name);
    }

    @Override
    public ProductDetailsPageBase clickOnProductPage(int index){
        waitUntil(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h5[@data-test='product-name']"),0), 10);
        productsNameList.get(index).click();
        return initPage(driver, ProductDetailsPageBase.class);
    }

}
