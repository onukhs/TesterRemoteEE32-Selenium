package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utils.TestBase;



public class LoginTest extends TestBase {

    @Test
    public void successLogin() {
        //Find element by ID 'user-name' and set valid username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Find element by ID 'password' and set valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Find Login button by CLASS and click on it
        driver.findElement(By.cssSelector(".submit-button")).click();
        //Assert that user is logged in
        driver.findElement(By.id("shopping_cart_container"));
    }

    @Test
    public void loginAsBlockedUser() {
        //Find element by ID 'user-name' and set valid username
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        //Find element by ID 'password' and set valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Find Login button by CLASS and click on it
        driver.findElement(By.cssSelector(".submit-button")).click();
        //"User is blocked" error message should be displayed
        driver.findElement(By.xpath("//*[contains(text(), 'Epic sadface: Sorry, this user has been locked out.')]"));
    }

    @Test
    public void loginAsInvalidUser() {
        //Find element by ID 'user-name' and set valid username
        driver.findElement(By.id("user-name")).sendKeys("invalid_username");
        //Find element by ID 'password' and set valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Find Login button by CLASS and click on it
        driver.findElement(By.cssSelector(".submit-button")).click();
        //"User is blocked" error message should be displayed
        driver.findElement(By.xpath("//*[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]"));
    }

}
