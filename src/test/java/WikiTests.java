import org.junit.jupiter.api.Test;
import pages.wiki.WikiHomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.wiki.WikiHomePage.WIKI_PLAYWRIGHT_URL;
import static util.Constants.PLAYWRIGHT;

public class WikiTests extends BaseTest{

    @Test
    void shouldSearchWiki() {
        WikiHomePage wikiHomePage = new WikiHomePage(page);
        wikiHomePage.navigate();
        wikiHomePage.search(PLAYWRIGHT);
        assertEquals(WIKI_PLAYWRIGHT_URL, page.url());
    }
}
