package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { 
//		"src/test/resources/features/functional/06_CreateVoucher.feature",
//		"src/test/resources/features/functional/PostForSale.feature",
//		"src/test/resources/features/functional/SetLocationWareHouse.feature",

								"src/test/resources/features/functional/22_Test.feature"

//		 src/test/resources/features/test.feature

}, glue = { "base", "stepdefinitions", "runner", "actions" }, monochrome = true,
//     dryRun = true,
		plugin = { "pretty", "json:target/cucumber-report/cucumber.json" })
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
