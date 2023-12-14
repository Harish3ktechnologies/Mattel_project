package Test_Scripts_Package;

import Libary.Baseclass;
import Pages_pom_package.Pom_Activites_for_kids;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activites_for_kids extends Baseclass
{
    private Page page;
    private Pom_Activites_for_kids pom_activites;
    @BeforeMethod
    public void setup()
    {
            this.page=super.getpage();
         pom_activites=new Pom_Activites_for_kids(page);
    }

    @Test(description = "Activites for kids comparsions",priority = 1)
    public void Activites_for_kids_verify() throws InterruptedException
    {


        pom_activites.for_parents_links();
        Thread.sleep(3000);
        pom_activites.Activities_for_kids();
        String Activites_url = page.url();
        Assert.assertEquals("https://shop.mattel.com/blogs/playroom/tagged/en-us-category-activities-for-kids",Activites_url);

    }
}
