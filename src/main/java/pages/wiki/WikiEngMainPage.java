package pages.wiki;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import util.Constants;

public class WikiEngMainPage {
    private final Page page;

    public static final String WIKI_ENG_MAIN_URL = "https://en.wikipedia.org/wiki/Main_Page";

    public WikiEngMainPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate(WIKI_ENG_MAIN_URL);
    }

    public Locator getWelcomeHeader() {
        return page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(Constants.WELCOME_TO_));
    }
}
