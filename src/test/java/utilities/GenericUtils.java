package utilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import static com.codeborne.selenide.Selenide.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.screenshot;

public class GenericUtils {
    private Properties prop;
    private FileInputStream fis;
    private HttpURLConnection connection;

    public GenericUtils() throws IOException {
        loadProperties();
    }

    public void loadProperties() throws IOException {
        prop = new Properties();
        if(System.getProperty("env").equals("int")) {
            fis = new FileInputStream("src/test/resources/int.properties");
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

      WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
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
    public String generateRandomString(int numberOfCharacters,boolean lettersWanted, boolean numbersWanted) {
        return RandomStringUtils.random(numberOfCharacters, lettersWanted, numbersWanted);
    }
    public void sendHttpRequest(String url) throws IOException {
        this.connection = (HttpURLConnection) new URL(url).openConnection();
        this.connection.setRequestMethod("GET");
        this.connection.connect();
    }

    public HttpURLConnection getConnection() {
        return this.connection;
    }

    public void scrollBy(int x, int y) {
        executeJavaScript("window.scrollBy[" + x + "," + y + "]");
    }
}

