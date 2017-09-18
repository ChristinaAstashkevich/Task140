package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDriver {

    public GridDriver() {

    }

        public static WebDriver driver;

        public static WebDriver getDriver(String browser) {
            DesiredCapabilities capability;
            //WebDriver driver = null;

            try {
                if (browser.equalsIgnoreCase("firefox")) {
                    capability = DesiredCapabilities.firefox();
                    capability.setBrowserName("firefox");
                    capability.setPlatform(org.openqa.selenium.Platform.ANY);
                    capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
                    WebDriver driver = null;

                    try {
                        driver = new RemoteWebDriver(new URL("http://10.10.102.45:5555/wd/hub"), capability);
                        return driver;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }


                } else if (browser.equalsIgnoreCase("chrome")) {
                    capability = DesiredCapabilities.chrome();
                    capability.setBrowserName("chrome");
                    capability.setPlatform(org.openqa.selenium.Platform.ANY);
                    WebDriver driver = null;
                    try {
                        driver = new RemoteWebDriver(new URL("http://10.10.102.45:5555/wd/hub"), capability);
                        return driver;
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                } else {
                    throw new IllegalArgumentException("The Browser Type is Undefined");
                }
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
                return driver;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return driver;
        }
    }

