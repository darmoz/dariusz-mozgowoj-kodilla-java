package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudTestngApp {

    public static final String XPATH = "//html/body/main/section/form/fieldset/input";
    public static final String XPATH_TEXTAREA = "//html/body/main/section/form/fieldset[2]/textarea";
    public static final String XPATH_WAIT = "//select[1]";
    public static final String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://darmoz.github.io/");

        WebElement searchField = driver.findElement(By.xpath(XPATH));
        searchField.sendKeys("Robotic task");

        WebElement textArea = driver.findElement(By.xpath(XPATH_TEXTAREA));
        textArea.sendKeys("New Robotic Task");

        while (!driver.findElement(By.xpath(XPATH_WAIT)).isDisplayed());

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(1);

    }
}
