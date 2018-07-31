package com.slate.pages.components;

import com.slate.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SideBarMenu extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Change the current view\"]")
    private MobileElement openMenu;

    public SideBarMenu(AndroidDriver driver) {
        super(driver);
    }

    public SideBarMenu open(){
        openMenu.click();
        return this;
    }

}
