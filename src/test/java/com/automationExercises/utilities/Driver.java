package com.automationExercises.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    private Driver() {
    }

    public static WebDriver driver;

    public static WebDriver get() {
        String browser = ConfigurationReader.get("browser");
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "chrome_download":
                    // İndirilen dosyaların kaydedileceği dizini belirliyoruz
                    String downloadFilePath = System.getProperty("user.dir") + "\\downloads";

                    // Chrome için opsiyonlar tanımlıyoruz
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");

                    // Eksperimental ayarlar yerine
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("download.default_directory", downloadFilePath);
                    prefs.put("download.prompt_for_download", false);
                    prefs.put("safebrowsing.enabled", "true");
                    options.setExperimentalOption("prefs", prefs);  // Bu satır ile experimental options veriyoruz
                    // ChromeDriver'ı opsiyonlarla başlatıyoruz
                    driver = new ChromeDriver(options);
                    break;
                case "chrome-headless":
                     options = new ChromeOptions();
                    options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    driver = new SafariDriver();
                    break;
            }

        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}