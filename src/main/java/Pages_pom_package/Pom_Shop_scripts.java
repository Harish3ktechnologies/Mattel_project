package Pages_pom_package;

import com.microsoft.playwright.Page;

public class Pom_Shop_scripts
{
    private Page page;
    public Pom_Shop_scripts(Page page)
    {
        this.page=page;
    }
    public void shop_hover_dropdown()
    {
        page.locator(".nav__list-wrap").locator("button").first().hover();
    }
    public void Shop_All()
    {
        page.getByText("Shop All").first().click();
    }
    public void Actions_figures_and_Playsets()
    {
        page.getByText("Action Figure & Playsets (579) ").click();
    }
    public void refresh()
    {
        page.locator("//div[@class='header__logo-container hide-mobile']").click();
    }
}
