package com.zebrunner.carina.demo.toolshop.gui.pages.android;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.GooglePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.NewTabPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewTabPageBase.class)
public class NewTabPage extends NewTabPageBase {

    @FindBy(id = "com.android.chrome:id/new_tab_view")
    private ExtendedWebElement newTabButton;

    public NewTabPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public GooglePageBase newTab() {
        newTabButton.click();
        return initPage(getDriver(), GooglePageBase.class);
    }
}
