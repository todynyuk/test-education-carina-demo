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
package com.zebrunner.carina.demo.toolshop.gui.pages.common;

import com.zebrunner.carina.demo.toolshop.gui.enums.ByCategoty;
import com.zebrunner.carina.demo.toolshop.gui.enums.SortDropdown;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickOnLoginButton();

    public abstract void searchForProduct(String query);

    public abstract List<String> getProductTitles();

    public abstract void getProductTitleText(String name);

    public abstract void clickOnDropdownMenu();

    public abstract void sortDropdownMenu(SortDropdown sortDropdown);

    public abstract boolean isProductsSortedFromLowToHighPrice();

    public abstract void setCheckboxByCategory(ByCategoty byCategory);

    public abstract boolean isChosenNameCorrect(String name);

    public abstract ProductDetailsPageBase clickOnProductPage(int index);

    public abstract boolean isFilterButtonPresent();

    public abstract void clickOnHamburgerMenu();

    public abstract LoginPageBase clickOnSingInButton();
}
