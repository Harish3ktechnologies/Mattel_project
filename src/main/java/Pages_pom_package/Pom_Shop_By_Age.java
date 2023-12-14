package Pages_pom_package;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Pom_Shop_By_Age
{
    private Page page;
    public Pom_Shop_By_Age(Page page)
    {
       this.page= page;
    }
    public void Shop_hover()
    {
        page.locator(".nav__list-wrap").locator("button").first().hover();
    }
    public void shop_by_age_six_to_tweleve()
    {
        page.getByText("6-12 Months").click();
    }
    public void shop_by_age_for_12_to_24_months()
    {
        page.getByText("12-24 Months").click();
    }
    public void Bady_gear()
    {
        page.getByText("Baby Gear (87) ").click();

    }
    public Locator result_count_of_Badygear()
    {
        return page.getByText("Results: 1-87 of 87");

    }
    public void Bady_Toys()
    {
        page.getByText("Baby Toys (192) ").click();
    }
    public void Bathtubs()
{
    page.getByText("Baby Bathtubs (12) ").click();
}
public Locator count_of_3_checkboxes_count()
{
    return page.getByText("Results: 1-12 of 12");
}
}
