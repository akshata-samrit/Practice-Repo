package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.OrderPage;
import Pages.ProductPage;

public class TC001 extends BaseTest 
{
	@Test
	public void addProductToCart() throws InterruptedException
	{
		HomePage home = new HomePage(driver, webActionUtil);
		home.clickOnDressesLink();
		home.selectProduct("4");
		ProductPage productPage = home.clickMoreButton("4");
		productPage.clickPlusButton(3);
		productPage.clickMinusButton(1);
		productPage.selectSize("L");
		productPage.selectColor("Pink");
		productPage.clickOnAddToCart();
		OrderPage orderPage = productPage.clickOnProceedToCheckOut();;
		Assert.assertTrue(orderPage.verifyProductIsDiplayed("4"));
	}
}
