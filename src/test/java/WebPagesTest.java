import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WebPagesTest {
    private WebDriver driver;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Booking.com | Oficjalna strona | Najlepsze hotele i nie tylko"})
    @Tag("Regression")
    @Tag("Booking")
    @Order(1)
    void pageOneTest(String title) {
        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(title, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"})
    @Tag("Regression")
    @Tag("Amazon")
    @Order(2)
    void pageTwoTest(String title) {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(title, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Pudelek.pl - Plotki, Gwiazdy, Sensacja - Pudelek"})
    @Tag("Regression")
    @Tag("Pudelek")
    @Order(3)
    void pageThreeTest(String title) {
        driver.get("https://www.pudelek.pl/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(title, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings = {"JUnit 5 User Guide"})
    @Tag("Regression")
    @Tag("Junit5 documentation")
    @Order(4)
    void pageFourTest(String title) {
        driver.get("https://junit.org/junit5/docs/current/user-guide/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(title, equalTo(actualTitle));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Maven Repository: Search/Browse/Explore"})
    @Tag("Regression")
    @Tag("Maven Repository")
    @Order(5)
    void pageFiveTest(String title) {
        driver.get("https://mvnrepository.com/");
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        assertThat(title, equalTo(actualTitle));
    }
}


