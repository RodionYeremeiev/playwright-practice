import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    public static final BrowserType.LaunchOptions HEADLESS_OFF = new BrowserType.LaunchOptions().setHeadless(false);

    @BeforeAll
    static void launchChromiumBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(HEADLESS_OFF);
    }

    @AfterAll
    static void closeBrowser(){
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void createContext(){
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext(){
        context.close();
    }
}
