package com.tchcareer.pages;

import org.openqa.selenium.support.PageFactory;
import static com.tchcareer.driver.Driver.getDriver;

public abstract class ParentPage {

    public ParentPage() {
        PageFactory.initElements(getDriver(),this);
    }

}
