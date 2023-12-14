package Libary;

import com.microsoft.playwright.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Config_property_reader;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
public class Baseclass
{
    protected BrowserContext browsercontext;
    Playwright playwright=Playwright.create();

    protected Page page;
      private BrowserContext browserContext;
    private Config_property_reader property_fetching;
    private Properties configproperties_reader;
    private Properties properties;
    @BeforeClass
    public void launch_browser() throws IOException
    {

        property_fetching= new Config_property_reader();
        configproperties_reader=property_fetching.propertyreader();
        String url =configproperties_reader.getProperty("Mattel_application_URL");
        String launching_browser=configproperties_reader.getProperty("browser");

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel(launching_browser).setArgs(Collections.singletonList("--start-maximized")));
        browserContext=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page=browserContext.newPage();
        page.navigate(url);
    }
    @AfterClass
    public void tear_down()
    {
        browserContext.close();
        page.close();
        playwright.close();
    }

    protected Page getpage()
    {
       return page;
    }
    protected BrowserContext get_browser_context()
    {
        return browserContext;
    }

}
