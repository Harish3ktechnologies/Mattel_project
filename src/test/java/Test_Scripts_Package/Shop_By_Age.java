package Test_Scripts_Package;

import Libary.Baseclass;
import Pages_pom_package.Pom_Shop_By_Age;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Shop_By_Age extends Baseclass
{

    private Page page;
    private Pom_Shop_By_Age pom_age;

    @BeforeMethod
   public void setup()
    {
        this.page=super.getpage();
        pom_age=new Pom_Shop_By_Age(page);
    }
    @Test(description ="Shop_by_Age_of_6_12_months",priority = 0)
    public void six_to_twelve_months() throws InterruptedException {
        pom_age.Shop_hover();
        pom_age.shop_by_age_six_to_tweleve();
        Thread.sleep(3000);
       String Shop_by_age_url = page.url();
        System.out.println(page.url());
        if(Shop_by_age_url.equalsIgnoreCase("https://shop.mattel.com/collections/age-6-12-months"))
        {
            Assert.assertTrue(true);
        }
    }
    @Test(description = "Shop_By_Age_for_12_to_24_months",priority = 1)
    public void shop_by_age_12_to_24_months()
    {
        pom_age.Shop_hover();
        pom_age.shop_by_age_for_12_to_24_months();
        String tweleve_to_twenty_four_months_url=page.url();
        System.out.println(tweleve_to_twenty_four_months_url);
        if(tweleve_to_twenty_four_months_url.equalsIgnoreCase("https://shop.mattel.com/collections/age-12-24-months"))
        {
            Assert.assertTrue(true);
        }
    }
    @Test(description = "Check_the_count_of_products while check the checkbox",priority = 1)
    public void count_of_products1() throws InterruptedException {
        pom_age.Shop_hover();
        Thread.sleep(3000);
        pom_age.shop_by_age_six_to_tweleve();
        pom_age.Bady_gear();
        Thread.sleep(4000);
        PlaywrightAssertions.assertThat(pom_age.result_count_of_Badygear()).isVisible();
    }
    @Test(description = "check_the_checkboxs and check the results",priority = 3)
    public void count_results1() throws InterruptedException {
        pom_age.Shop_hover();
        pom_age.shop_by_age_six_to_tweleve();
        pom_age.Bady_gear();
        pom_age.Bady_Toys();
        Thread.sleep(3000);
        page.getByText("Type").click();
        Thread.sleep(3000);
        pom_age.Bathtubs();
        Thread.sleep(3000);
        PlaywrightAssertions.assertThat(pom_age.count_of_3_checkboxes_count()).isVisible();
    }

}
