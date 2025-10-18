import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {

    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    public static final BrowserType.LaunchOptions HEADLESS_OFF = new BrowserType.LaunchOptions().setHeadless(false);

    @BeforeAll
    static void launchChromiumBrowser(){
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

//    public void test() {
//
//            Page page = browser.newPage();
//            page.navigate("https://playwright.dev/");
//
//            // Expect a title "to contain" a substring.
//            assertThat(page).hasTitle(Pattern.compile("Playwright"));
//
//            // create a locator
//            Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));
//
//            // Expect an attribute "to be strictly equal" to the value.
//            assertThat(getStarted).hasAttribute("href", "/docs/intro");
//
//            // Click the get started link.
//            getStarted.click();
//
//            // Expects page to have a heading with the name of Installation.
//            assertThat(page.getByRole(AriaRole.HEADING,
//                    new Page.GetByRoleOptions().setName("Installation"))).isVisible();
//
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
//    }

}
