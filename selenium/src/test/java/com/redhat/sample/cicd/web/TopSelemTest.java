package com.redhat.sample.cicd.web;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopSelemTest {

    private WebDriver driver;

    private String baseUrl = "http://localhost:8080/order-manage";

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test_list() throws InterruptedException {
        driver.navigate().to(baseUrl + "/index.html");
        waitForLoad(driver, 30);
        Assert.assertThat(driver.findElement(By.tagName("table"))
                .findElements(By.tagName("tr")).size(), Matchers.is(1));
    }

    private void waitForLoad(WebDriver driver, int timeout) {
        new WebDriverWait(driver, timeout)
                .until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

}
