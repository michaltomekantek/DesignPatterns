package com.designpaterns.facade.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class BrowserService {

    private static final Map<Browsers, Supplier<WebDriver>> WEBDRIVER_SUPPLIER;

    static {
        final Map<Browsers, Supplier<WebDriver>> drivers = new EnumMap<>(Browsers.class);
        drivers.put(Browsers.FIREFOX, FirefoxDriver::new);
        drivers.put(Browsers.CHROME, ChromeDriver::new);
        drivers.put(Browsers.OPERA, OperaDriver::new);

        WEBDRIVER_SUPPLIER = Collections.unmodifiableMap(drivers);
    }

    private static final String SELENIUM_HUB = "";
    private WebDriver driver;



    public BrowserService() {
        ProcessExecutor.startSeleniumHub();
        ProcessExecutor.startChromeWebDriver();
        ProcessExecutor.startFirefoxWebDriver();
    }

    public WebDriver getDriver(Browsers browser) {
        Supplier<WebDriver> webDriver = WEBDRIVER_SUPPLIER.get(browser);

        if (webDriver == null) {
            throw new RuntimeException("Nie znaleziono przeglądarki");
        }

        return WEBDRIVER_SUPPLIER.get(browser).get();
    }

    private WebDriver initFireFoxDriver(){
        return new FirefoxDriver();
    }




}
