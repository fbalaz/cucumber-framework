package utilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.OutputType;
import static com.codeborne.selenide.Selenide.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import static com.codeborne.selenide.Selenide.screenshot;

public class GenericUtils {
    private Properties prop;
    private FileInputStream fis;

    public GenericUtils() throws IOException {
        loadProperties();
    }

    public void loadProperties() throws IOException {
        prop = new Properties();
        if(System.getProperty("env").equals("test")) {
            fis = new FileInputStream("src/test/resources/testenv.properties");
            prop.load(fis);
        }
    }

    public void chooseBrowser() {
        String browser = System.getProperty("browser");
        switch (browser) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "safari":
                Configuration.browser = "safari";
                break;
            }

        }



    public Properties getProp() {
        return prop;
    }

    public byte[] takeScreenshot() {
        String screenshotAsBase64 = screenshot(OutputType.BASE64);
        byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
        return decoded;
    }

    public void customWait(long seconds) throws InterruptedException {

      Thread.sleep(seconds*1000);
    }

    public void switchWindow() {
        String parentHandle = WebDriverRunner.getWebDriver().getWindowHandle();
        Set<String> windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equalsIgnoreCase(parentHandle)) {
                switchTo().window(windowHandle);
                break;
            }
        }
    }
}

