package com.guru99.pages;

import commonLibs.implentation.ElementControl;
import org.openqa.selenium.WebDriver;

import javax.swing.text.Element;

public class BasePage {
        WebDriver driver;
        public ElementControl elementControl;
        public BasePage(WebDriver driver){
            this.driver=driver;
            elementControl = new ElementControl(driver);
        }
}
