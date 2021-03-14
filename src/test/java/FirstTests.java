import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FirstTests {
    @Test
    public void chromDriverTest() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://calc.by/weight-and-calories/body-mass-index-calculator.html");
        WebElement height = driver.findElement(By.id("bmiVar1"));
        height.sendKeys("183");

        WebElement weight = driver.findElement(By.id("bmiVar2"));
        weight.sendKeys("58");

        WebElement calcBtn = driver.findElement(By.className("btn-calculate"));
        calcBtn.click();

        WebElement bmiNumber = driver.findElement(By.id("AnswerBMI"));
        String bmiNumberText = bmiNumber.getText();

        WebElement status = driver.findElement(By.id("AnswerBMI1"));
        String statusText = status.getText();

        Assert.assertEquals(bmiNumberText, "17.32");
        Assert.assertEquals(statusText, "Недостаточной массе тела");

        driver.quit();

    }

        @Test
        public void chromDriverTest2() {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
            String absolutePath = file.getAbsolutePath();

            System.setProperty("webdriver.chrome.driver", absolutePath);

            ChromeDriver driver = new ChromeDriver();

            driver.get("https://calc.by/building-calculators/laminate.html");

            WebElement lenght = driver.findElement(By.id("ln_room_id"));
            lenght.clear();
            lenght.sendKeys("429");

            WebElement width = driver.findElement(By.id("wd_room_id"));
            width.clear();
            width.sendKeys("319");

            WebElement lenghtlam = driver.findElement(By.id("ln_lam_id"));
            lenghtlam.clear();
            lenghtlam.sendKeys("1000");

            WebElement widthlam = driver.findElement(By.id("wd_lam_id"));
            widthlam.clear();
            widthlam.sendKeys("190");

            WebElement packing = driver.findElement(By.id("n_packing"));
            packing.clear();
            packing.sendKeys("5");

            WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
            Select layingMethodLaminate = new Select(selectWebElement);

            layingMethodLaminate.selectByIndex(0);
            layingMethodLaminate.selectByValue("1");
            layingMethodLaminate.selectByVisibleText("с использованием отрезанного элемента");

            List<WebElement> list = driver.findElements(By.name("direction-laminate"));

            for (WebElement option : list) {
                if (option.getAttribute("value").equals("2")) {
                    option.click();
                }
            }

            WebElement segment = driver.findElement(By.id("min_length_segment_id"));
            segment.clear();
            segment.sendKeys("5");

            WebElement walls = driver.findElement(By.id("indent_walls_id"));
            walls.clear();
            walls.sendKeys("9");

            WebElement direction = driver.findElement(By.id("direction-laminate-id2"));
            direction.click();

            WebElement calc = driver.findElement(By.linkText("Рассчитать"));
            calc.click();

            driver.close();




    }

    @Test
    public void chromDriverTest3() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement roomwidth = driver.findElement(By.name("calc_roomwidth"));
        roomwidth.sendKeys(Keys.chord(Keys.CONTROL, "a"), "2");

        WebElement roomheight = driver.findElement(By.name("calc_roomheight"));
        roomheight.sendKeys(Keys.chord(Keys.CONTROL, "a"), "2");

        WebElement lamwidth = driver.findElement(By.name("calc_lamwidth"));
        lamwidth.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1200");

        WebElement lamheight = driver.findElement(By.name("calc_lamheight"));
        lamheight.sendKeys(Keys.chord(Keys.CONTROL, "a"), "190");

        WebElement inpack = driver.findElement(By.name("calc_inpack"));
        inpack.sendKeys(Keys.chord(Keys.CONTROL, "a"), "11");

        WebElement price = driver.findElement(By.name("calc_price"));
        inpack.sendKeys(Keys.chord(Keys.CONTROL, "a"), "400");

        WebElement selectWebElement = driver.findElement(By.name("calc_direct"));
        Select layingdirection = new Select(selectWebElement);
        layingdirection.selectByVisibleText("По ширине комнаты");

        WebElement bias = driver.findElement(By.name("calc_bias"));
        bias.sendKeys(Keys.chord(Keys.CONTROL, "a"), "250");

        WebElement walldist = driver.findElement(By.name("calc_walldist"));
        walldist.sendKeys(Keys.chord(Keys.CONTROL, "a"), "9");

        WebElement calc = driver.findElement(By.className("btn btn-secondary btn-lg tocalc"));
        calc.click();

        driver.close();



    }

}

