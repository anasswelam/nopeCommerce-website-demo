package Runner;

import cucumber.api.CucumberOptions;
import tests.BaseTest;

@CucumberOptions(features="src/test/java/Features"
,glue={"steps"}
,plugin= {"pretty","html:target/cucumber-html-report"})

public class TestRunner extends BaseTest{
	

}
