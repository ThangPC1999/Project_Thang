package runner;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {

}, glue = { "base", "stepdefinitions", "runner" }, monochrome = true,
//,dryRun = true	
		plugin = { "pretty", "json:target/cucumber.json" })
public class CucumberTestRunnerParallel extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeClass
	public void setupClassName(ITestContext context) {

		context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(5);
		context.getCurrentXmlTest().getSuite().setPreserveOrder(false);
	}
}