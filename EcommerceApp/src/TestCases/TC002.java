package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import GenericLibrary.GenericExcelLibrary;
import Pages.HomePage;
import Pages.OrderPage;
import Pages.ProductPage;

public class TC002 extends BaseTest 
{
	@DataProvider
	public Object[][] getData()
	{
		return GenericExcelLibrary.getExcelData(XL_PATH, "TC001");
	}
	
	
	@Test(dataProvider="getData")
	public void addProductToCartFromExcel(String productId, String size, String color)
	{
		productId=productId.substring(0, 1);
		HomePage home = new HomePage(driver, webActionUtil);
		home.clickOnDressesLink();
		home.selectProduct(productId);
		ProductPage productPage = home.clickMoreButton(productId);
		productPage.clickPlusButton(3);
		productPage.clickMinusButton(1);
		productPage.selectSize(size);
		productPage.selectColor(color);
		productPage.clickOnAddToCart();
		OrderPage orderPage = productPage.clickOnProceedToCheckOut();;
		Assert.assertTrue(orderPage.verifyProductIsDiplayed(productId));
	}
}
