# JavaSeleniumTest

Create at least the following tests: 
1. Open the application and make sure a list of movie tiles is displayed. 
2. Open the movie The Shawshank Redemption and make sure the release date is correctly displayed. 
3. Search for Star Trek and make sure that the movie Star Trek: First Contact is displayed in the search results and the movie The Shawshank Redemption is no longer visible. 
4. 4. Take any movie you like and make sure the Released on, popularity, vote average and vote count fields have the expected values. 
5. Did you encounter any bugs in the application? If so, add a test that shows that bug. 

I have used Intellij to write the code.
After opening the project it is required to add the Selenium library [1] to the project:
  File > Project Structure > Libraries > + (New Project Library / Alt+Insert) > Select "selenium-server-4.1.4.jar" from your computer > Apply > OK
  
In the JavaSeleniu.class it is required to change path to the "chromedriver.exe" with the one from your computer. You can download it here [2].

        //TODO change the file path of chromedriver.exe, from your computer.
        System.setProperty("webdriver.chrome.driver","D:\\SDA\\dev\\software\\chromedriver_win32\\chromedriver.exe");
        
To run the test you should only hit Run'JavaSelenium.main()' and the output should look like this [3]. If you encounter any errors or the output does not show as mentioned please run it again a few times.

One thing I would suggest to the developper to change is to add “id” tags to the “div” so it can be found easier with findElement(By.id()) instead of findElement(By.xpath()).

Additionally he could add an “Search” button to the search bar. And the search box should clear automatically after a search is made.


[1]: https://www.selenium.dev/downloads/

[2]: https://chromedriver.chromium.org/downloads

[3]: https://gyazo.com/b24f4aad50b86ac7d0a5fdde256b1dc8
