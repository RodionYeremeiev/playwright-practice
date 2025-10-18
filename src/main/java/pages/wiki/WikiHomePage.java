package pages.wiki;

import com.microsoft.playwright.Page;

import static util.Constants.ENTER;

public class WikiHomePage {
    private final Page page;

    public static final String WIKI_HOME_URL = "https://www.wikipedia.org/";
    public static final String WIKI_PLAYWRIGHT_URL = "https://en.wikipedia.org/wiki/Playwright";

    public static final String INPUT_NAME_SEARCH = "input[name=\"search\"]";

    public WikiHomePage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate(WIKI_HOME_URL);
    }

    public void search(String input) {
        page.locator(INPUT_NAME_SEARCH).fill(input);
        page.locator(INPUT_NAME_SEARCH).click();
        page.locator(INPUT_NAME_SEARCH).press(ENTER);
    }

    public WikiEngMainPage chooseLanguage(String input) {
        page.getByTitle("English — Wikipedia — The Free Encyclopedia").click();
        return new WikiEngMainPage(page);
    }
}
