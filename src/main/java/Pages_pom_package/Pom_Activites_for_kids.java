package Pages_pom_package;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Pom_Activites_for_kids
{
    private Page page;
    public Pom_Activites_for_kids(Page page)
    {
        this.page=page;
    }

    public void for_parents_links()
    {
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("For Parents")).click();
    }
    public void Activities_for_kids()
    {
        page.locator("//ul[@class='brand-nav__list hide-mobile']//li[3]").click();
    }

}
