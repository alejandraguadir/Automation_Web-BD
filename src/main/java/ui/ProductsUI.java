package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class ProductsUI extends PageObject {
    public static final Target PRODUCT = Target.the("product").
            located(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
    public static final Target PRODUCT_NAME = Target.the("prodouct name").
            located(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/div[1]"));
    public static final Target PRICE = Target.the("price product").
            located(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/div"));
}
