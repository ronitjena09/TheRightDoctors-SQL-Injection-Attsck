package com.ronit.sqli;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumSQLiTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Program Files (x86)//ChromeDriver//chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C://Program Files//Google//Chrome//Application//chrome.exe");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to OWASP Juice Shop login page
            driver.get("https://juice-shop.herokuapp.com/#/login");

            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));

            String maliciousUsername = "' OR '1'='1";
            String validPassword = "password";

            usernameField.sendKeys(maliciousUsername);
            passwordField.sendKeys(validPassword);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
            loginButton.click();

            wait.withTimeout(Duration.ofSeconds(30));

            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'error') and contains(@class, 'ng-star-inserted')]")));


            if (errorMessage.isDisplayed()) {
                System.out.println("SQL Injection attempt failed with message: " + errorMessage.getText());
            } else {
                System.out.println("No error message found. Check the application behavior manually.");
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Timeout waiting for the error message. Check the locator or increase the timeout.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
