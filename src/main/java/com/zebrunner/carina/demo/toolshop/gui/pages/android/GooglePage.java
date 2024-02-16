package com.zebrunner.carina.demo.toolshop.gui.pages.android;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.GooglePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.NewTabPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GooglePageBase.class)
public class GooglePage extends GooglePageBase {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Chrome']")
    private ExtendedWebElement googleLinks;

    @FindBy(className = "android.widget.EditText")
    private ExtendedWebElement googleSearchInputField;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.android.chrome:id/line_1'])[1]/parent::*")
    private ExtendedWebElement searchText;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Switch or close tabs']")
    private ExtendedWebElement switchTabButton;

    @FindBy(xpath = "(//android.widget.RelativeLayout[@resource-id='com.android.chrome:id/card_view'])[1]")
    private ExtendedWebElement firstTab;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openBrowser() {
        googleLinks.click();
    }

    @Override
    public HomePageBase googleSearch(String url) {
        googleSearchInputField.type(url);
        searchText.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public LoginPageBase googleSearchLogin(String url) {
        googleSearchInputField.type(url);
        searchText.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public NewTabPageBase showAllTab() {
        switchTabButton.click();
        return initPage(getDriver(), NewTabPageBase.class);
    }

    @Override
    public boolean isSearchInputPresent() {
        return googleSearchInputField.isElementPresent();
    }

    @Override
    public HomePageBase goToHomePage() {
        firstTab.click();
        return initPage(getDriver(), HomePageBase.class);
    }
}
