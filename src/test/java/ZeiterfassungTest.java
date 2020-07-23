import de.schubert42.zeiterfassung.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ZeiterfassungTest {

    private WebDriver webDriver;

    @Test
    public void Druecken_auf_Kommen_Button_zeigt_aktuelle_Zeit_und_aendert_sich_in_Gehen() {
        starteAnwendungMit("12:00:00 Uhr");
        oeffneZeiterfassung();
        drueckeKommen();

        assertZeitWirdAnzeigt("12:00:00 Uhr");
        assertGehenButtonWirdAngezeigt();
    }

    private void drueckeKommen() {
        WebElement kommenButton = webDriver.findElement(By.id("kommen"));
        kommenButton.click();
    }

    private void oeffneZeiterfassung() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        webDriver = new ChromeDriver(options);
        webDriver.get("localhost:8080/zeiterfassung");
    }

    private void assertGehenButtonWirdAngezeigt() {
        WebElement gehenButton = webDriver.findElement(By.id("gehen"));
    }

    private void assertZeitWirdAnzeigt(String uhrzeit) {
        WebElement zeit = webDriver.findElement(By.id("zeit"));
        Assertions.assertEquals(uhrzeit,zeit.getText());
    }

    private void starteAnwendungMit(String uhrzeit) {
        Thread thread = new Thread(() -> Main.main(new String[]{uhrzeit}));
        thread.start();
    }
}
