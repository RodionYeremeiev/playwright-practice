import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Test;
import pages.wiki.WikiEngMainPage;
import pages.wiki.WikiHomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.wiki.WikiEngMainPage.WIKI_ENG_MAIN_URL;
import static pages.wiki.WikiHomePage.WIKI_PLAYWRIGHT_URL;
import static util.Constants.*;

public class WikiTests extends BaseTest {
    WikiHomePage wikiHomePage;
    WikiEngMainPage wikiEngMainPage;

    @Test
    void shouldSearchWiki() {
        openHomePage();
        wikiHomePage.search(PLAYWRIGHT);
        assertEquals(WIKI_PLAYWRIGHT_URL, page.url());
    }

    @Test
    void shouldSwitchToEnglishMainPage() {
        openHomePage();
        wikiHomePage.chooseLanguage(ENGLISH);
        assertEquals(WIKI_ENG_MAIN_URL, page.url());
    }

    @Test
    void shouldDisplayWelcomeHeader() {
        navigateToEngMainPage();
        Locator welcomeHeader = wikiEngMainPage.getWelcomeHeader();
        PlaywrightAssertions.assertThat(welcomeHeader).isVisible();
        PlaywrightAssertions.assertThat(welcomeHeader).containsText(WELCOME_TO_WIKIPEDIA);
    }

    private void navigateToEngMainPage() {
        wikiEngMainPage = new WikiEngMainPage(page);
        wikiEngMainPage.navigate();
    }

    public void openHomePage() {
        wikiHomePage = new WikiHomePage(page);
        wikiHomePage.navigate();
    }

}
