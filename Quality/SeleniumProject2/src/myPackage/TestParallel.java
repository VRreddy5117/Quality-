package myPackage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParallel {

	@DataProvider(parallel=true)
	public Object[][] getData(){
		return new Object[][]{ {"test 1"},
				{"test 2"},
				{"test 3"}
		};
	}


	@Test(dataProvider="getData")
	public void test_01(String value){
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		driver.get("http://www.w3schools.com/");
		driver.findElement(By.xpath("html/body/div[2]/div/a[4]")).click();
		driver.findElement(By.xpath("//*[@id='gsc-i-id1']")).sendKeys(value);

		driver.quit();
	}
}
