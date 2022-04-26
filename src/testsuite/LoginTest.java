package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilityTest;

public class LoginTest extends UtilityTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateTLoginPageSuccessfully(){
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        verifyText(By.xpath("//h1[contains(text(),'Welcome Back!')]"), "Welcome Back!");
    }
    @Test
    public  void verifyTheErrorMessage(){
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        sendTextToElement(By.id("user[email]"), "12@gmail.com");
        sendTextToElement(By.id("user[password]"), "ABC123");
        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        verifyText(By.xpath("//li[contains(text(),'Invalid email or password.')]"), "Invalid email or password.");

    }
}
