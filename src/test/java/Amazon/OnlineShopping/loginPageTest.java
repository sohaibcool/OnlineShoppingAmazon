package Amazon.OnlineShopping;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopping.qa.base.TestBase;
import com.shopping.qa.pages.LoginPage2;

public class loginPageTest extends TestBase {
	LoginPage2 loginPage; 
	public loginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{ 
		initialization();
		loginPage= new LoginPage2();
		
	}
	
	@Test(priority=1)
	public void loginPageTitelTest() {
		String title =loginPage.verifyHomePageTile();
		Assert.assertEquals(title, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		
	}
	
	@Test(priority=2)
	public void AmazonLogTest() {
		boolean flag=loginPage.validateImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws IOException
	{
		loginPage.loginAmazon(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
