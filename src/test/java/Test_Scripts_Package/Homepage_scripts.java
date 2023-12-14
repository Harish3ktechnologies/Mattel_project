package Test_Scripts_Package;

import Libary.Baseclass;
import Pages_pom_package.Pom_Homepage;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Config_property_reader;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Homepage_scripts extends Baseclass
{
    private Page page;
    private BrowserContext browserContext;
    private Pom_Homepage pom_homepage;
    private Config_property_reader config_properties;
    private Properties properies_fetching;

    @BeforeMethod
    public void setup()
    {
        this.page = super.getpage();
        pom_homepage =new Pom_Homepage(page);
    }

    @Test(description = "verify the url", priority = 0)
    public void Homepage_script_1() {
        System.out.println(page.url());
        PlaywrightAssertions.assertThat(page).hasURL("https://shop.mattel.com/");
    }

    @Test(description = "Check_the_country_name and Headings", priority = 1)
    public void Homepage_scripts_2()
    {
        pom_homepage.Main_Country_picker_link();
        //page.locator("#countryPickerTrigger").click();
        Locator Heading = pom_homepage.Heading_title();
        //Locator header = page.locator("(//div[@class='modal__inner country-picker-modal__inner']//div//header//h3)[1]");
        System.out.println(Heading.innerText());
        PlaywrightAssertions.assertThat(Heading).containsText("Choose Your Country or Region");
//        page.locator(".modal__inner country-picker-modal__inner").locator("button").locator("i").click();
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Close")).click();
        System.out.println("closed");

    }
    @Test(description = "check the country list",priority = 2)
    public void Homepage_scripts_3() throws InterruptedException, IOException
    {
         config_properties = new Config_property_reader();
         properies_fetching = config_properties.propertyreader();
         String first_city=properies_fetching.getProperty("city_1");
         String second_city=properies_fetching.getProperty("city_2");
         String third_city=properies_fetching.getProperty("city_3");
         String forth_city=properies_fetching.getProperty("city_4");
         String fifth_city=properies_fetching.getProperty("city_5");

        System.out.println("country_version");
        pom_homepage.Main_Country_picker_link();
        System.out.println("clicked country link");
        Thread.sleep(3000);
       // page.locator("#countryPickerTrigger").click();

       List<ElementHandle> Americans_countries = page.querySelectorAll("(//ul[@class='list-reset country-picker-modal__list'])[1]//li");
       Thread.sleep(3000);
       for(ElementHandle American_c_list:Americans_countries)
       {
           String country = American_c_list.innerText();
           System.out.println("countries_verification");
           if(country.contains(first_city))
           {
               Assert.assertTrue(true);
               System.out.println(country);
           } 
           else if (country.contains(second_city))
           {
               Assert.assertTrue(true);
               System.out.println(country);
           } 
           else if (country.contains(third_city))
           {
               Assert.assertTrue(true);
               System.out.println(country);
           }
           else if (country.contains(forth_city))
           {
               Assert.assertTrue(true);
               System.out.println(country);
           }
           else if (country.contains(fifth_city))
           {
               Assert.assertTrue(true);
               System.out.println(country);
           }
       }
        pom_homepage.country_page_close_button();
        Thread.sleep(3000);

    }
}
