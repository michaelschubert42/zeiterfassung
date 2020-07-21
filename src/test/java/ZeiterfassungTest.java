import de.schubert42.zeiterfassung.Main;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.wildfly.common.Assert;

public class ZeiterfassungTest {

    private WebDriver webDriver;

    @Test
    public void Druecken_auf_Kommen_Button_zeigt_aktuelle_Zeit_und_aendert_sich_in_Gehen() {
        starteAnwendung();
        oeffneZeiterfassung();
        drueckeKommen();

        assertZeitWirdAnzeigt("12:00:00 Uhr");
        assertGehenButtonWirdAngezeigt();
    }

    private void drueckeKommen() {
            //WebElement kommenButton = webDriver.findElement(By.id("kommen"));
    }

    private void oeffneZeiterfassung() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        webDriver = new ChromeDriver(options);
        webDriver.get("localhost:8080/zeiterfassung");
    }

    private void assertGehenButtonWirdAngezeigt() {
    }

    private void assertZeitWirdAnzeigt(String uhrzeit) {

    }

    private void starteAnwendung() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Main.main(new String[]{});
            }
        };
        thread.start();
    }
}
