package Pages_pom_package;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public class Pom_Homepage
{
    private Page page;
    public Pom_Homepage(Page page)
    {
        this.page=page;
    }

    public void Main_Country_picker_link()
    {
        page.locator("#countryPickerTrigger").click();

    }
    public Locator Heading_title()
    {
       return page.locator("(//div[@class='modal__inner country-picker-modal__inner']//div//header//h3)[1]");
    }
    public void refresh()
    {
        page.locator("//div[@class='header__logo-container hide-mobile']").click();
    }
    public void country_page_close_button()
    {
        page.locator("//div[@class='modal__inner country-picker-modal__inner']//button[1]//span").click();
    }

}
