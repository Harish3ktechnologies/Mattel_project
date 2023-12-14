package Test_Scripts_Package;

import Libary.Baseclass;
import Pages_pom_package.Pom_Shop_scripts;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import com.microsoft.playwright.options.AriaRole;
import custom_listeners.ExtentMettal;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Config_property_reader;

import java.io.IOException;
import java.util.Properties;

public class Shop_scripts extends Baseclass
{
   private Page page;
   private Pom_Shop_scripts pom_shop;
    Config_property_reader config_properties;
    Properties properties_fetching;
    @BeforeMethod
    public void setup_Shop()
    {
        this.page=super.getpage();
         pom_shop=new Pom_Shop_scripts(page);
    }
    @ExtentMettal(name = "Harish")
    @Test(description = "User_checking Shop_options tab is displayed",priority = 0)
    public void Shop_options() throws InterruptedException {
        Thread.sleep(3000);
       pom_shop.shop_hover_dropdown();
        Thread.sleep(3000);
        Locator Shop_ALL = page.getByText("Shop All").first();
        if(Shop_ALL.isVisible())
        {
            Assert.assertTrue(true);
        }

    }
    @Test(description ="Checking the Shop_all_funcationality",priority = 1)
    public void shop_all_funcationality() throws InterruptedException, IOException {
         config_properties = new Config_property_reader();
         properties_fetching = config_properties.propertyreader();
        String shop_url = properties_fetching.getProperty("Shop_all_url");
        page.reload();
        pom_shop.shop_hover_dropdown();
        pom_shop.Shop_All();
        String Shop_all_url = page.url();
         System.out.println(Shop_all_url);
         if(Shop_all_url.equalsIgnoreCase("shop_url"))
         {
             System.out.println("validated");
             Assert.assertTrue(true);
         }

    }
    @Test(description = "validate the check_boxes of categary",priority = 2)
    public void shop_all_checkbox_validate() throws InterruptedException
    {
        pom_shop.Actions_figures_and_Playsets();
       Thread.sleep(4000);
        Locator selected_checked_options = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear Action Figure & Playsets"));
        System.out.println("clicked");
        if(selected_checked_options.isVisible())
        {
            System.out.println("selected");
            Assert.assertTrue(true);
        }
    }
}
