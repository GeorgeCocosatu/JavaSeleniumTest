package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaSelenium {

    String webSite = "https://betterqa.ro/top-movies/";

    public static void main(String[] args) {

        //TODO change the file path of chromedriver.exe, from your computer.
        System.setProperty("webdriver.chrome.driver","D:\\SDA\\dev\\software\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Actions goToSearchBox = new Actions(driver);
        JavaSelenium test = new JavaSelenium();

    try {
        //  1. Open the application and make sure goToSearchBox list of movie tiles is displayed.
        test.logIn(driver);

        //  2. Open the movie The Shawshank Redemption and make sure the release date is correctly displayed.
        test.verifyReleaseDate(driver);

        //  3. Search for Star Trek and make sure that the movie Star Trek: First Contact is displayed in the search results and the movie The Shawshank Redemption is no longer visible.
        String movieName = "Star Trek: First Contact";
        test.clearSearchBox(driver);
        test.searchForMovie(driver,goToSearchBox,movieName);
        test.clearSearchBox(driver);

        //  4. Take any movie you like and make sure the Released on, popularity, vote average and vote count fields have the expected values.
        String movieNameTwo = "The Dark Knight";
        test.clearSearchBox(driver);
        test.searchForMovie(driver,goToSearchBox,movieNameTwo);
        test.clearSearchBox(driver);
        test.verifyStatistics(driver);

        test.endSession(driver);
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    public void logIn(WebDriver driver){
        driver.get(webSite);
        driver.manage().window().maximize();

        WebElement password = driver.findElement(By.id("pwbox-4212"));
        password.sendKeys("do_not_share!1");

        WebElement submit = driver.findElement(By.name("Submit"));
        submit.click();
    }

    public  void verifyReleaseDate(WebDriver driver) {
        WebElement moreTheShawshankRedeption = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button"));
        moreTheShawshankRedeption.click();

        String valueReleaseDateTSR = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[2]/div/input")).getAttribute("value");
        String correctReleaseDateTSR = "1994-09-23";

        if (valueReleaseDateTSR.equalsIgnoreCase(correctReleaseDateTSR)){
            System.out.println("The Shawshank Redemption has the correct release date displayed!");
        }else {
            System.out.println("The Shawshank Redemption has the incorrect release date displayed!");
        }

        WebElement closeMoreTheShawshankRedeption = driver.findElement(By.cssSelector("body > div.jss87.jss80 > div.jss10.jss36.jss11.jss81.jss83 > div.jss140 > button"));
        closeMoreTheShawshankRedeption.click();
    }

    public void searchForMovie (WebDriver driver, Actions goToSearchBox, String movieName) {

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input"));
        goToSearchBox.moveToElement(searchBox).click().build().perform();

        searchBox.sendKeys(movieName);
        searchBox.submit();
    }

    public void verifyStatistics (WebDriver driver) {

        WebElement moreTheDarkKnight = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button"));
        moreTheDarkKnight.click();

        String valueReleaseDateTDK = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[2]/div/input")).getAttribute("value");
        String valuePopularity = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[3]/div/input")).getAttribute("value");
        String valueRating = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[4]/div/input")).getAttribute("value");
        String valueVoteCount = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[5]/div/input")).getAttribute("value");


        String correctReleaseDateTDK = "2008-07-14";
        String actualPopularity = "67";
        String actualRating = "9.6";
        String actualVoteCount = "2556563";

        if (valueReleaseDateTDK.equalsIgnoreCase(correctReleaseDateTDK)){
            System.out.println("The Dark Knight has the correct release date displayed!");
        }else {
            System.out.println("The Dark Knight has the incorrect release date displayed! The correct ones are " + correctReleaseDateTDK);
        }

        if (valuePopularity.equalsIgnoreCase(actualPopularity)){
            System.out.println("The Dark Knight has the correct popularity displayed!");
        }else {
            System.out.println("The Dark Knight has the incorrect popularity displayed! The correct value is " + actualPopularity);
        }

        if (valueRating.equalsIgnoreCase(actualRating)){
            System.out.println("The Dark Knight has the correct rating displayed!");
        }else {
            System.out.println("The Dark Knight has the incorrect rating displayed! The correct value is " + actualRating);
        }

        if (valueVoteCount.equalsIgnoreCase(actualVoteCount)){
            System.out.println("The Dark Knight has the correct vote count displayed!");
        }else {
            System.out.println("The Dark Knight has the incorrect vote count displayed! The correct value is " + actualVoteCount);
        }
    }

    public void clearSearchBox(WebDriver driver){
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input"));

        while(!searchBox.getAttribute("value").equals("")){
            searchBox.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void endSession (WebDriver driver){
        driver.close();
    }
}
