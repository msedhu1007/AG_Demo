package com.tests;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
 
public class GetFullPageScreenShot
{
    public static String capture(WebDriver driver, String screenShotName) throws Exception
    {
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        String dest = System.getProperty("user.dir") + "/screenshots/" + screenShotName + timeStamp +".png";
        ImageIO.write(screenshot.getImage(),"PNG",new File(dest));
        return dest;
    }
}