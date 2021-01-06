package mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertEquals;

public class Calc {

    private AndroidDriver<MobileElement> driver; //Igual ao WebDriver driver

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); //configuracao
    /*
        // Emulador local
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "UIAutomator2");
        // desiredCapabilities.setCapability("deviceName", "eumlator5554"); ussa esse quando for fazer com um celular local(fisico) ou na nuvem
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("platformVersion", "10.0");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
    */
        // Executar na nuvem via Test Object

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "UIAutomator2");
        desiredCapabilities.setCapability("deviceName", "Samsung_Galaxy_S9_free");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("platformVersion", "10.0");
        desiredCapabilities.setCapability("testobject_api_key", "E19372E1855F4DA38B278E665194793C");


        URL remoteUrl = new URL("https://us1.appium.testobject.com/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() throws InterruptedException {
        // Prepara ou configura
        MobileElement btn2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        btn2.click();
        MobileElement btnsomar = (MobileElement) driver.findElementByAccessibilityId("plus");
        btnsomar.click();
        MobileElement btn3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        btn3.click();
        MobileElement btnigual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnigual.click();
        MobileElement visor = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");



        // Valida
        assertEquals("5", visor.getText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
